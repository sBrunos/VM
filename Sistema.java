public class Sistema {
	
	public VM vm;

    public Sistema(){   // a VM com tratamento de interrupções
		 vm = new VM();
	}

	public static void main(String args[]) {
		Sistema s = new Sistema();
		s.test2();
		s.test1();
	}

	public void test1(){
		Auxiliar aux = new Auxiliar();
		Word[] p = new Programs().fibonacci10;
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

}

