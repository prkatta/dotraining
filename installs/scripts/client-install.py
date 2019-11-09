import os, time, subprocess,  json
from pprint import pprint


with open('/client-test/scripts/versions.json') as f:
    data = json.load(f)

git_clients= data["git-clients"]
gitlfs_clients= data["gitlfs-clients"]
pprint(git_clients)
pprint(gitlfs_clients)

def client_install():

    # install Git clients in docker image
    if len(git_clients):
        install_git_client()
    else:
        print ("Git client list is empty, Please install stable and tested git client")

    # install gitLFS clients in docker image
    if len(gitlfs_clients):

        install_gitlfs_client()
    else:
        print ("GitLFS client list is empty, Please install stable and tested gitLFS client")


def install_git_client():

    for client in git_clients:
		
        print ("Git Client v"+client + " installing .....")
        cmd = "./client-test/scripts/git-client-install.sh "+client
        command_runner(cmd)


def install_gitlfs_client():

    for client in gitlfs_clients:

        print ("GitLFS client v"+client + " installing..... ")
        url = gitlfs_clients.get(client)
        cmd = "./client-test/scripts/gitlfs-client-install.sh "+client +" "+ url
        command_runner(cmd)


def command_runner(cmd):

    print(cmd)
    p = subprocess.Popen(cmd, shell=True, stdout=subprocess.PIPE, stderr=subprocess.STDOUT)
    for line in p.stdout.readlines():
        print (line)


client_install()