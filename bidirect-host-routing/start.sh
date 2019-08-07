#!/bin/sh

iptables -t nat -A PREROUTING -p tcp --dport $SRC_PORT -j DNAT --to-destination $HOST_IP:$DST_PORT
iptables -t nat -A POSTROUTING -j MASQUERADE

# to keep the container running
read input