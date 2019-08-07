FROM ubuntu

RUN \
    apt-get update && \
    apt-get -y install iptables

COPY start.sh /start.sh

CMD ["/start.sh"]