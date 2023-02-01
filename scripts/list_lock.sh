#!/usr/bin/env sh
awslocal --region=eu-west-2 dynamodb scan --table-name SpringIntegrationLockRegistry | jq '.Items[] | {lockKey: .lockKey, ownerName: .ownerName}'
