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

  yumt update -y
  yum install -y ntpdate  tree rsync curl wget unzip vim rpm-build rsync net-tools nodejs python2 python3 maven
  #ntpdate 0.centos.pool.ntp.org

  curl -fsSL https://get.docker.com/ | sh

  systemctl start docker
  systemctl status docker
  systemctl enable docker
  usermod -aG docker vagrant
  docker info
  docker run hello-world

  echo "Centos provisioning is  completed................................................"
