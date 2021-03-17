package MutanteDeAço;
import robocode.*;
import java.awt.Color;

public class MutanteDeAço extends Robot
{
	boolean andar = true; //Variavel que auxilia na movimentação d robô.
	int giro = 1; //Variavel para auxiliar na realização do giro.
	boolean tiro_certo = false; //Variavel para auxiliar se o tiro acertou o adversario.
 	boolean tiro_falhou = false; //Variavel para auxiliar que o tiro não acertou o adversario

	
	
	public void run() { //Metodo chamado quando o jogo inicia e esta sempre em execução.
	
		colorRobot(); //Chamando o metodo com as cores atribuida ao Robô.
		
		while(true) {
		
				if(andar == true){ //verifica se a avariavel andar é igual a true e inicia a movimentação.
				
					for(int x=1;x<=2;x++){ // repete a movomentação por 2 vezes.
						ahead(100); //Anda para a frente 100px.
						turnRight(90); // Vira para a direita 90 graus.
						turnGunRight(360); // Vira a arma para a direita 360 graus.
						scan(); //Procurar outros robôs.
					}
				
					for(int y=1;y<=2;y++){ // repete a movomentação por 2 vezes.
						back(100);  //Anda para a trás 100px.
						turnLeft(90); // Vira para a esquerda 90 graus.
						turnGunLeft(360); // Vira a arma para a esquerda 360 graus.
						scan(); //Procurar outros robôs.
					}
					andar = false; //variavel assume o valor de false
				}else{ //verifica se a avariavel andar é igual a false e inicia a movimentação.
					for(int w=1;w<=2;w++){ // repete a movomentação por 2 vezes.
						ahead(50); //Anda para a frente 50px.
						turnRight(45); // Vira para a direita 45 graus.
						turnGunRight(360); // Vira a arma para a direita 360 graus.
						scan(); //Procurar outros robôs.
					}
				
					for(int z=1;z<=2;z++){ // repete a movomentação por 2 vezes.
						back(50);  //Anda para a trás 50px.
						turnLeft(45); // Vira para a esquerda 45 graus.
						turnGunLeft(360); // Vira a arma para a esquerda 360 graus.
						scan();  //Procurar outros robôs.
					}
					andar = true; //variavel assume o valor de false
				}
				
		}
	}

		/*
	 Método chamado quando o radar do robor encontra um adversário.
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
	
			if (e.getBearing() >= 0) { //Verifica se o ângulo do robô adversario é maior do que 0.
				giro = 1; //Realiza o giro no sentido horário
			}else {
				giro = -1; //Caso contrario a condição não seja atendida o robô realiza o giro no sentido anti-horário
			}
				
				turnRight(e.getBearing()); // Robo da um giro para a direita com o angulo do adiversario.
				
				
				if (tiro_certo == true && tiro_falhou == false) { //Se o tiro dado acertou o adversario ele entra na condição.
				
	 					if (e.getEnergy() > 0){ //verifica se a energia do adversario é > 0 e se atender entra na condição.
						
								/*
								 * Verifica a energia do adversario e a sua distancia para tomar a decisão da potencia da bala.
								 */
								if (e.getEnergy() > 16 && e.getDistance()<= 300) {
								fire(3);
								} else if (e.getEnergy() > 10 && e.getDistance() <= 300 ) {
								fire(2);
								} else if (e.getEnergy() > 4) {
								fire(1);
								} else if (e.getEnergy() > 2) {
								fire(.5);
								} else if (e.getEnergy() > .4) {
								fire(.1);
							}	}	

			}else { //Se a bala não acertar o adversario a decisão é dar um tiro de potencia 1.
				
				fire(1); // Tiro de potencia 1.
				
		 	}							
				ahead(10); // Andar para frente 10px
				scan(); // usa o radar novamente para localizar os oponentes.
				
	}

	/*
	 Método chamado quando o robô recebe um tiro.
	 */
	public void onHitByBullet(HitByBulletEvent e) {
	
		double anguloTiro = e.getBearing(); //Saber qual o angulo esta o tiro
		turnRight(-anguloTiro); //Vira para o lado oposto do tiro
	  	ahead(100); // Andar para frente 10px.

	}
	
	/*
	 Método chamado quando o robô atinge a parede.
	 */
	public void onHitWall(HitWallEvent e) {
		double anguloParede= e.getBearing(); //Saber qual o angulo esta a parede
	  turnRight(-anguloParede); //Vira para o lado oposto o da parede
	  ahead(100); // Andar para frente 10px.
	}
	
	/*
	Método chamado quando o robô colide com outro robô.
	*/
	public void onHitRobot(HitRobotEvent e){ 
		
		if (e.getBearing() >= 0) { //Verifica se o ângulo do robô adversario é maior do que 0.
				giro = 1; //Realiza o giro no sentido horário
			}else {
				giro = -1; //Caso contrario a condição não seja atendida o robô realiza o giro no sentido anti-horário
			}
				
				turnRight(e.getBearing()); // Robo da um giro para a direita com o angulo do adiversario.
				
		/*
		 * Verifica a energia do adversario para tomar a decisão da potencia da bala.
		 */
		if (e.getEnergy() > 16) {
			fire(3);
			} else if (e.getEnergy() > 10) {
			fire(2);
			} else if (e.getEnergy() > 4) {
			fire(1);
			} else if (e.getEnergy() > 2) {
			fire(.5);
			} else if (e.getEnergy() > .4) {
			fire(.1);
			}		
	}
		
	/*
	Método chamado quando o tiro atingir o adversário.
	*/
	public void onBulletHit(BulletHitEvent e) {

		tiro_certo = true; //Variavel para auxiliar na decisão do tiro.
		tiro_falhou = false; //Variavel para auxiliar na decisão do tiro.

	}	
	
	/*
	Método chamado quando erra o tiro.
	*/
	public void onBulletMissed(BulletMissedEvent e) {
	
		tiro_falhou = true; //Variavel para auxiliar na decisão do tiro.
		tiro_certo = false; //Variavel para auxiliar na decisão do tiro.

	}
	
	/*
	 * Metodo criado para atribuir as cores de cada um dos componentes do robô.
	 */
	public void colorRobot() {
			
		setBodyColor(Color.blue);    //Adicionada a cor azul para o corpo do tanque.
		setGunColor(Color.black);    //Adicionada a cor preta para a arma do tanque.
		setRadarColor(Color.white);  //Adicionada a cor branca para o radar do tanque.
		setScanColor(Color.red);     //Adicionada a cor vermelha para o scan do tanque.
		setBulletColor(Color.white); //Adicionada a cor branca para a bala do tanque. 
			
	}
}
