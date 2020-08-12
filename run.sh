docker rm fdp-app -f
docker run --restart=always --name fdp-app   -p 6443:8181 -d -v /opt/fdp/logs/:/opt/fdp/logs/ fdp-app:1.0.0
