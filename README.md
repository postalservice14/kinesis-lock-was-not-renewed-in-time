
# Demo project to reproduce KinesisMessageDrivenChannelAdapter : The lock for key 'xxxxx' was not renewed in time


`./gradlew build` -  to build the project both producer and consumer modules


`docker-compose -f docker-local.yml up --build -d`  - to spin Localstack with Kinesis and DynamoDb, one producer instance and 3 consumer instances


## To recreate the issue:

- Run the steps above
- `./scripts/list_lock`  - to see who is the owner of 2 shards now.

If you are lucky you get different owners and should be able to see lock exception  on 2 of those 3 running instances.
- If the owner for 2 shards is the same, then you need to restart the active consuming consumer and run again `./scripts/list_lock` to see if you are lucky and have two owners for two shards now and exception.
- If not continue to restart the active instance until you get one shard has one owner and another shard has another owner.



