#!/bin/sh

VERSION=$1
GITLFS_URL=$2
TAR_EXT=".tar.gz"
echo $VERSION
echo $GITLFS_URL

if test -z "$VERSION"
 then
    echo Missing Git client version, Please enter required version
    exit 1
fi

cd  /tools/gitlfs/
mkdir "git-lfs-$VERSION"
cd "git-lfs-$VERSION"
echo "Downloading gitlfs client version v$VERSION $GITLFS_URL "
wget "$GITLFS_URL"
tar -zxvf git-lfs-*.gz
rm -rf /tools/gitlfs/git-lfs-*.gz