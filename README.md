# springboot-kotlin
<p>스프링 부트 프로젝트를 코틀린으로 진행해봤습니다.
<br>
서버간 통신의 구현이 이번 프로젝트의 목적입니다.
<br>
프로젝트 안에는 총 3개의 서버가 있습니다(UserServer, OrderServer, Kafka)
<br>서버간에 Retrofit2 를 사용해서 서로의 API 를 호출할 수 있도록 했습니다.
<br>시간이 소요되는 내부 로직이 수행된 후에는 Kafka 서버로 메시지를 발행하고, 다른 서버에서 해당 메시지를 수신할 수 있도록 했습니다.
<br>

Kafka 를 이용한 비동기 메시지 큐 방식의 통신과, Retrofit2 를 이용한 API 호출을 학습했습니다.
</p>
