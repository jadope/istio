# istio
Proposed challenge. Putting in practice what learnt on this course: https://www.udemy.com/course/istio-hands-on-for-kubernetes/

Took from: https://github.com/lectrapb/kubernates-challenge-goty

## Note:
Port on BFF service was changed from 5000 to 42000 due to MAC issues. You can check out the arquitecture graph in documentation/images to see the small change.

## Technical requirements responses:
1. [Docker image of BFF](https://hub.docker.com/repository/docker/jad0pe/bff/general)
## API Reference of BFF

### Port
42000

#### getSimilarsId

```http
  GET /api/goty/similars/${id}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `int` | **Required**. Product id |

#### getProducts

```http
  GET /api/goty/products
```


For the next solvings, these commands could be helpful
Useful commands: 

  ```bash
kubectl apply -f <YMLFileWithInstructions>
kubectl get services
kubectl get po
kubectl describe service <Service name>
kubectl port-forward <pods name> <local port>:<cluster port>
minikube mount shared/:/minikube/shared/
```

2.  Located in folder:  `Kubernetes/1.simple`
3.  Located in folder:  `Kubernetes/2.istio_implementation`
4. istioctl version:
   - client version: 1.23.2+
   - control plane version: 1.22.3
   - data plane version: 1.22.3 (2 proxies)
5. Done in `Kubernetes/2.istio_implementation`
6. Located in folder: `Kubernetes/3.canary`
7. Located in folder: `Kubernetes/4.ingress_gateway`
8. Located in folder `Kubernetes/5.circuit_breaking`
9. You are in the repository already as you're reading this, files are in Kubernetes folder.
10. As mentioned above, it is.

Thanks for reading!
