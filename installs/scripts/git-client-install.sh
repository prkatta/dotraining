#!/bin/sh

VERSION=$1
TAR_EXT=".tar.gz"
echo $VERSION

 if test -z "$VERSION"
    then
    echo Missing Git client version, Please enter required version
    exit 1
fi

mkdir "/tools/git-client/$VERSION"
cd  /tools/git-client/

echo "Downloading git client version v$VERSION https://github.com/git/git/archive/v$VERSION$TAR_EXT"
wget "https://github.com/git/git/archive/v$VERSION.tar.gz"

tar -zxf "v$VERSION$TAR_EXT"
cd "git-$VERSION"
make configure
./configure --prefix=/usr/local/git
make all
make install
cp -R /usr/local/git "/tools/git-client/$VERSION"
rm -rf "/tools/git-client/git-$VERSION"
rm -rf "/tools/git-client/v$VERSION$TAR_EXT"