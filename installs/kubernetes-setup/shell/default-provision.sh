  if [ ! -d "/data" ]; then
	  mkdir /data
  fi
  if [ ! -d "/opt/devops/code" ]; then
	  mkdir -p /opt/devops/code
  fi

  echo "updating locale"
  echo 'LANG="en_US.UTF-8"' > /etc/locale.conf
  mkdir -p /auto/ecs/bin
  # rsync -avz /home/vagrant/devops /data/.
  chown vagrant:vagrant -R /opt/devops/code


  echo "exit 0" > /auto/ecs/bin/install-dotfiles
  chmod +x /auto/ecs/bin/install-dotfiles
  echo "installing ntpdate"

  yum update -y
  yum install -y ntpdate  tree rsync curl wget unzip vim rpm-build rsync net-tools nodejs python2 python3 maven git
  #ntpdate 0.centos.pool.ntp.org
  #sed -i 's/PasswordAuthentication no/PasswordAuthentication yes/g' /etc/ssh/sshd_config
  #systemctl restart sshd;
  cp devops/id_rsa* .ssh/
  cat devops/id_rsa.pub >> .ssh/authorized_keys
  chown -R vagrant:vagrant /home/vagrant/.ssh
  chmod 600 /home/vagrant/.ssh/id_rsa
  cp /vagrant/config/resolv.conf /etc/

  #curl -fsSL https://get.docker.com/ | sh
  yum remove docker* -y
  yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
  yum install docker-ce-18.06.3.ce-3.el7 -y

  systemctl start docker
  systemctl status docker
  systemctl enable docker
  usermod -aG docker vagrant
  docker info
  docker run hello-world

  echo "Centos provisioning is  completed................................................"
