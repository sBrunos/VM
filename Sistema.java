import java.util.Scanner;

public class Sistema {
	
	public VM vm;

    public Sistema(){   // a VM com tratamento de interrupções
		 vm = new VM();
	}

	public static void main(String args[]) {
		Sistema s = new Sistema();
		// System.out.println("\n TESTE DE IO : INPUT");// Esperado inteiro como input do usuario para ser armazenado.
		// s.testaTrapIN();
		// System.out.println("\n TESTE DE IO : OUTPUT"); // Esperado o valor 30 como output
		// s.testaTrapOUT();
		int i = 0;
		do{
			System.out.println("Digite o número do que deseja fazer");
			System.out.println("1 - Fatorial");
			System.out.println("2 - Fibonacci");
			System.out.println("3 - Fibonacci de 10");
			System.out.println("4 - BubbleSort");
			System.out.println("5 - Sair");
			Scanner scan = new Scanner(System.in);

			i = scan.nextInt();
			switch(i){
				case 1: s.fatorial();
						break;
				case 2: s.fibonacci();
						break;
				case 3: s.fibonacci10();
						break;
				case 4: s.bubbleSort();
						break;
				case 5: System.out.println("Tchau!");
			}
		}
		while(i != 4);

	}

	public void fatorial(){
		Auxiliar aux = new Auxiliar();
		Word[] p = new Programs().fatorial;
		aux.carga(p, vm.m);
		vm.cpu.setContext(0);
		System.out.println("---------------------------------- programa carregado ");
		aux.dump(vm.m, 0, 33);
		System.out.println("---------------------------------- após execucao ");
		vm.cpu.run();
		aux.dump(vm.m, 0, 33);
	}

	public void test2(){
		Auxiliar aux = new Auxiliar();
		Word[] p = new Programs().progMinimo;
		aux.carga(p, vm.m);
		vm.cpu.setContext(0);
		System.out.println("---------------------------------- programa carregado ");
		aux.dump(vm.m, 0, 15);
		System.out.println("---------------------------------- após execucao ");
		vm.cpu.run();
		aux.dump(vm.m, 0, 15);
	}

	public void fibonacci10(){

		Auxiliar aux = new Auxiliar();
        Word[] p = new Programs().fibonacci10;
        aux.carga(p, vm.m);
        vm.cpu.setContext(0);
        System.out.println("---------------------------------- programa carregado ");
        aux.dump(vm.m, 0, 70);
        System.out.println("---------------------------------- após execucao ");
        vm.cpu.run();
        aux.dump(vm.m, 0, 70);
		
	}


	public void fibonacci(){

		Auxiliar aux = new Auxiliar();
        Word[] p = new Programs().fibonacci;
        aux.carga(p, vm.m);
        vm.cpu.setContext(0);
        System.out.println("---------------------------------- programa carregado ");
        aux.dump(vm.m, 0, 50);
        System.out.println("---------------------------------- após execucao ");
        vm.cpu.run();
        aux.dump(vm.m, 0, 50);
		
	}

	public void bubbleSort(){

		Auxiliar aux = new Auxiliar();
        Word[] p = new Programs().fatorial;
        aux.carga(p, vm.m);
        vm.cpu.setContext(0);
        System.out.println("---------------------------------- programa carregado ");
        aux.dump(vm.m, 0, 70);
        System.out.println("---------------------------------- após execucao ");
        vm.cpu.run();
        aux.dump(vm.m, 0, 70);
		
	}



	public void testaTrapIN(){
        Auxiliar aux = new Auxiliar();
        Word[] p = new Programs().trapIn;
        aux.carga(p, vm.m);
        vm.cpu.setContext(0);
        System.out.println("---------------------------------- programa carregado ");
        aux.dump(vm.m, 0, 10);
        System.out.println("---------------------------------- após execucao ");
        vm.cpu.run();
        aux.dump(vm.m, 0, 10);
    }

	public void testaTrapOUT(){
        Auxiliar aux = new Auxiliar();
        Word[] p = new Programs().trapOut;
        aux.carga(p, vm.m);
        vm.cpu.setContext(0);
        System.out.println("---------------------------------- programa carregado ");
        aux.dump(vm.m, 0, 10);
        System.out.println("---------------------------------- após execucao ");
        vm.cpu.run();
        aux.dump(vm.m, 0, 10);
    }

}

