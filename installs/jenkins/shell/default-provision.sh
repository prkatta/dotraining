
	# create devops directory
	mkdir -p /opt/devops/

	echo "updating locale"
	echo 'LANG="en_US.UTF-8"' > /etc/locale.conf
	cat /home/vagrant/devops/id_rsa.pub >>  /home/vagrant/.ssh/authorized_keys
	export LANG=en_US.UTF-8
