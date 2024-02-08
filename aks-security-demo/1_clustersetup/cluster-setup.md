#### install etcd:
```sh
apt-get -y install wget
mkdir /root/binaries
cd /root/binaries

wget https://github.com/etcd-io/etcd/releases/download/v3.5.4/etcd-v3.5.4-linux-amd64.tar.gz

tar -xzvf etcd-v3.5.4-linux-amd64.tar.gz
cd etcd-v3.5.4-linux-amd64

cp etcd etcdctl /usr/local/bin/

etcd

etcdctl put course "kplabs-cks course is awesome"
etcdctl get course

```


#### configure ca:
```sh

mkdir /root/certificates
cd /root/certificates

openssl genrsa -out ca.key 2048
openssl req -new -key ca.key -subj "/CN=KUBERNETES-CA" -out ca.csr
openssl x509 -req -in ca.csr -signkey ca.key -CAcreateserial  -out ca.crt -days 1000

rm -f ca.csr

```

#### etcd-transit-encryption:

```sh

apt-get -y install tcpdump net-tools

cd /tmp
etcd


tcpdump -i lo -X  port 2379

etcdctl put course "cks"
etcdctl get course


cd /root/certificates
openssl genrsa -out etcd.key 2048


ifconfig





```
