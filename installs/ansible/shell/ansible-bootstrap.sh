
  yum install epel-release -y
  yum install ansible -y

  cat devops/hosts >>/etc/ansible/hosts
  mkdir /etc/ansible/group_vars
  echo "ansible_ssh_user: vagrant" >> servers

  echo "Ansible host provisioning is  completed................................................"
