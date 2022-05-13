#!/usr/bin/env sh
aws --endpoint-url=http://localhost:4566 dynamodb scan --table-name SpringIntegrationLockRegistry | jq '.Items[] | {lockKey: .lockKey, ownerName: .ownerName}'
