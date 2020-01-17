Dev Notes
---

### Admin Login Credentials

admin/admin

### Exporting the configuration

docker exec -it dpe-keycloak /opt/jboss/keycloak/bin/standalone.sh \
-Djboss.socket.binding.port-offset=100 \
-Dkeycloak.migration.action=export \
-Dkeycloak.migration.provider=singleFile \
-Dkeycloak.migration.realmName=Digital_Payments_Engine \
-Dkeycloak.migration.usersExportStrategy=REALM_FILE \
-Dkeycloak.migration.file=/tmp/realm.json

### Getting an access token from the test realm using cURL

export access_token=$(\
    curl -X POST http://localhost:8180/auth/realms/Digital_Payments_Engine/protocol/openid-connect/token \
    --user digital-payments-engine-app:40b536cc-10f1-4857-9e83-2685c7d3e238 \
    -H 'content-type: application/x-www-form-urlencoded' \
    -d 'username=simonkent@sky.com&password=password&grant_type=password' | jq --raw-output '.access_token' \
 )

### Executing a request via cURL

curl -v -X GET http://localhost:8080/ -H "Authorization: Bearer "$access_token
