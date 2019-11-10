sudo rpm -ivh http://yum.puppetlabs.com/puppetlabs-release-el-7.noarch.rpm
sudo rpm -ivh http://dl.fedoraproject.org/pub/epel/epel-release-latest-7.noarch.rpm
sudo yum -y install http://yum.theforeman.org/releases/1.9/el7/x86_64/foreman-release.rpm
sudo yum update -y
sudo yum -y install foreman-installer
sestatus
#disable SElinux, replace SELINUX=disabled

vi /etc/sysconfig/selinux
sestatus

sudo foreman-installer


#Agent setup

sudo yum -y install ntp ntpdate

sudo systemctl start ntpd
sudo systemctl enable ntpd#
#Disable SElinux
vim /etc/sysconfig/selinux

#Latest version of puppet lab setup
sudo yum -y install https://yum.puppet.com/puppet6-release-el-7.noarch.rpm
sudo yum -y install http://dl.fedoraproject.org/pub/epel/epel-release-latest-7.noarch.rpm
sudo yum -y install https://yum.theforeman.org/releases/1.23/el7/x86_64/foreman-release.rpm
sudo yum update -y
sudo yum -y install foreman-installer
#edit /etc/host with wrong dns entries

sudo foreman-installer
