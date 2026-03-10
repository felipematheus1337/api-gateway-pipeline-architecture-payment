<img src="https://github.com/felipematheus1337/api-gateway-pipeline-architecture-payment/blob/develop/assets/architecture-draw.JPG?raw=true" />

<h1>Spring Cloud</h1>
<h1>Spring Data MongoDB</h1>

Feature:
3 Filters:
- Validation
- Payment
- Notification

<h2>The Notification can be using e-mail and SMS(AWS SNS)</h2>

Design Patterns used:
Strategy for multiples payments strategies.
Factory for different types of notification

Architecture used:
- Pipeline for the workflow
- Layered with some domain isolation

