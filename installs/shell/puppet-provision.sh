
	# create devops directory


	rpm -ivh https://yum.puppetlabs.com/el/7/products/x86_64/puppetlabs-release-7-10.noarch.rpm
	rpm -ivh https://dl.fedoraproject.org/pub/epel/epel-release-latest-7.noarch.rpm
	
	rpm -ivh http://yum.puppetlabs.com/puppetlabs-release-el-7.noarch.rpm

	#rpm -ivh https://yum.puppet.com/puppet5/puppet5-release-el-7.noarch.rpm
	rpm -ivh http://yum.theforeman.org/releases/1.10/el7/x86_64/foreman-release.rpm
	yum install -y ntpdate puppet-server foreman-installer tree
	ntpdate 0.centos.pool.ntp.org

	chkconfig puppetmaster on && service puppetmaster start
	foreman-installer

	# update autosign for puppet
	cp /home/vagrant/devops/puppet.autosign.conf /etc/puppet/autosign.conf

	ln -s /etc/puppet/environments/production/modules /opt/devops/modules
	puppet agent -t
	puppet module install puppetlabs/stdlib

