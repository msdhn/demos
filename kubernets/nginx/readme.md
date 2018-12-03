
run the below commands

- kubectl apply -f deployment.yml
- kubectl apply -f service.yml

<ul>
  <li>from within the cluster access using  nginx-svc:80</li>
  <li>from outside the cluster access using  nginx-svc:30001 provided nginx-svc can be resolved</li>
</ul>
