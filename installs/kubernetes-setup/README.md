#Prerequisites

#Vagrant
#Create Single master and multi node K8s cluster, it installs docker exclusively
vagrant up --provision

# install rke
https://rancher.com/docs/rke/latest/en/installation/
MacOS: rke_darwin-amd64
Linux (Intel/AMD): rke_linux-amd64
Linux (ARM 32-bit): rke_linux-arm
Linux (ARM 64-bit): rke_linux-arm64
Windows (32-bit): rke_windows-386.exe
Windows (64-bit): rke_windows-amd64.exe

#Configure rke
rke config --name cluster.yml

# private key path
/Users/cloudbearers/Desktop/kp/Training/DevOps/k8s/kubernetes-setup/config/id_rsa


# Start k8s cluster
rke up

# set kubeconfig to environment variable
export KUBECONFIG=/Users/cloudbearers/Desktop/kp/Training/DevOps/k8s/kubernetes-setup/kube_config_cluster.yml
kubectl --kubeconfig=kube_config_cluster.yml get nodes

kubectl --kubeconfig=kube_config_cluster.yml get pods -A
# Deploying nginx deployment controller
kubectl apply -f samples/controllers/nginx-deployment.yaml --kubeconfig=kube_config_cluster.yml

kubectl --kubeconfig=kube_config_cluster.yml get deployments

kubectl --kubeconfig=kube_config_cluster.yml get rs


#Updating a Deployment

kubectl --kubeconfig=kube_config_cluster.yml  --record deployment.apps/nginx-deployment set image deployment.v1.apps/nginx-deployment nginx=nginx:1.9.1

kubectl edit deployment.v1.apps/nginx-deployment --kubeconfig=kube_config_cluster.yml

kubectl rollout status deployment.v1.apps/nginx-deployment --kubeconfig=kube_config_cluster.yml

#Rolling Back a Deployment
kubectl set image deployment.v1.apps/nginx-deployment nginx=nginx:1.91 --record=true --kubeconfig=kube_config_cluster.yml


#Checking Rollout History of a Deployment
kubectl rollout history deployment.v1.apps/nginx-deployment --kubeconfig=kube_config_cluster.yml
kubectl annotate deployment.v1.apps/nginx-deployment kubernetes.io/change-cause="image updated to 1.9.1" --kubeconfig=kube_config_cluster.yml

kubectl rollout history deployment.v1.apps/nginx-deployment --revision=2 --kubeconfig=kube_config_cluster.yml

kubectl rollout undo deployment.v1.apps/nginx-deployment --kubeconfig=kube_config_cluster.yml
kubectl rollout undo deployment.v1.apps/nginx-deployment --to-revision=2 --kubeconfig=kube_config_cluster.yml

#Scaling a Deployment
kubectl scale deployment.v1.apps/nginx-deployment --replicas=10 --kubeconfig=kube_config_cluster.yml

kubectl set image deployment.v1.apps/nginx-deployment nginx=nginx:sometag --kubeconfig=kube_config_cluster.yml

kubectl rollout history deployment.v1.apps/nginx-deployment --kubeconfig=kube_config_cluster.yml

kubectl get rs --kubeconfig=kube_config_cluster.yml

kubectl set resources deployment.v1.apps/nginx-deployment -c=nginx --limits=cpu=200m,memory=512Mi --kubeconfig=kube_config_cluster.yml
kubectl rollout resume deployment.v1.apps/nginx-deployment --kubeconfig=kube_config_cluster.yml

kubectl get rs -w --kubeconfig=kube_config_cluster.yml
kubectl rollout status deployment.v1.apps/nginx-deployment --kubeconfig=kube_config_cluster.yml
kubectl describe deployment nginx-deployment --kubeconfig=kube_config_cluster.yml

kubectl get deployment nginx-deployment -o yaml --kubeconfig=kube_config_cluster.yml


# StatefulSets controller
kubectl apply -f samples/application/web/web.yaml --kubeconfig=kube_config_cluster.yml

kubectl get all --kubeconfig=kube_config_cluster.yml

#Delete deployment controllers

kubectl delete deployment.apps/nginx-deployment --kubeconfig=kube_config_cluster.yml
kubectl delete horizontalpodautoscaler.autoscaling/nginx-deployment --kubeconfig=kube_config_cluster.yml


kubectl get pods -w -l app=nginx --kubeconfig=kube_config_cluster.yml

kubectl get pod -o=custom-columns=NAME:.metadata.name,STATUS:.status.phase,NODE:.spec.nodeName --all-namespaces --kubeconfig=kube_config_cluster.yml
kubectl get service nginx --kubeconfig=kube_config_cluster.yml
