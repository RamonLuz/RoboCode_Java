# RoboCode_Java

## MutanteDeAço

## Linguagem:

Como o robô estava disponível para ser programado em javal ou C# foi tomada a decisão de realizar a programação com java, pois a documentação na internet era maior e de mais fácil entendimento.

# O robô:

## onScannedRobot:

A primeira decisão do robô nesse metodo é verificar se o angulo do adversario é maior ou igual a 0 para realizar a decisão do sentido do seu giro para que seu tiro seja realizado sempre na direção de algum adversario, logo em seguida ele verifica com base nas informaçoies passada apos o primeiro tiro que sera de potencia 1, se o metodos onBulletHit retornou como true e false para ele entrar na condição que acertou o adversario e ir para a proxima condição de verificar a energia e a distancia do adversario para saber se da um tiro de potencia mais baixa ou mais alta, mas se caso o primeiro tiro retornar o metodo onBulletMissed  com true e false ele vai dar um tiro de potencia 1.

## onHitByBullet:

Quado um tiro acerta o robô ele vai verificar de qualangulo veio o tiro e girar para o sendito contrario e andar para a frente, assim evitando que outros tiros do oponente o acerte novamente.

## onHitWall:

Quando o robô atinge a parede ele vai verificar o angulo da parede e girar no sentido contrario e andar para a frente, evitando com que fique preso na parede e vire um alvo facil para os adversarios.

## onHitRobot:

Nesse metodo o robo faz basicamente a mesma opção de quando escanear o adversario, pois ele verifica a direção do adversario e depois a energia para poder tomar a decisão de qual a potencia de tiro a ser realizada.

## onBulletHit:

Nesse metodo o robô tem duas variaves que assumento valor de true e false que informam se o robo acertou o adversario com a bala, para orientar na tomada de decisão do proximo tiro a ser realizado.

## onBulletMissed:

Nesse metodo o robô tem duas variaves que assumento valor de true e false que informam se o robo errou o adversario com a bala, para orientar na tomada de decisão do proximo tiro a ser realizado.

## colorRobot

Nesse metodo adicionamos as cores de cada componente do robo e depois o chamamos no metodo run.

* Adicionada a cor azul para o corpo do tanque.
* Adicionada a cor preta para a arma do tanque.
* Adicionada a cor branca para o radar do tanque.
* Adicionada a cor vermelha para o scan do tanque.
* Adicionada a cor branca para a bala do tanque.
