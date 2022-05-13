package com.example.demo;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsync;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient;
import com.amazonaws.services.kinesis.AmazonKinesisAsync;
import com.amazonaws.services.kinesis.AmazonKinesisAsyncClient;
import io.awspring.cloud.autoconfigure.context.ContextInstanceDataAutoConfiguration;
import io.awspring.cloud.autoconfigure.context.ContextRegionProviderAutoConfiguration;
import io.awspring.cloud.autoconfigure.context.ContextStackAutoConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

@EnableBinding({OutputChannel.class})
@SpringBootApplication(
		exclude = {
				ContextInstanceDataAutoConfiguration.class,
				ContextStackAutoConfiguration.class,
				ContextRegionProviderAutoConfiguration.class
		}
)
@Slf4j
public class KinesisProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KinesisProducerApplication.class, args);
	}

	@Bean
	public AmazonKinesisAsync amazonKinesis() {
		String kinesisUrl = "http://kinesis.stream:4566";
		String accessKey = "localstack";
		String secretKey = "localstack";

		log.info("Connecting to Kinesis on: {}", "");
		System.setProperty("com.amazonaws.sdk.disableCbor", "1");
		BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
		return AmazonKinesisAsyncClient.asyncBuilder()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(kinesisUrl, "eu-west-2"))
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
				.build();
	}

	@Bean
	AmazonDynamoDBAsync amazonDynamoDBAsync() {
		String dynamodbUrl = "http://kinesis.stream:4566";
		String accessKey = "localstack";
		String secretKey = "localstack";
		log.info("Connecting to DynamoDB on: {}", dynamodbUrl);
		BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
		return AmazonDynamoDBAsyncClient.asyncBuilder()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(dynamodbUrl, "eu-west-2"))
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
				.build();
	}

}
