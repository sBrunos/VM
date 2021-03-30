public class Programs {
    public Word[] progMinimo = new Word[] {
        new Word(Opcode.LDI, 0, -1, 999), 		
        new Word(Opcode.STD, 0, -1, 10), 
        new Word(Opcode.STD, 0, -1, 11), 
        new Word(Opcode.STD, 0, -1, 12), 
        new Word(Opcode.STD, 0, -1, 13), 
        new Word(Opcode.STD, 0, -1, 14), 
        new Word(Opcode.STOP, -1, -1, -1) };

   public Word[] fibonacci10 = new Word[] { // mesmo que prog exemplo, so que usa r0 no lugar de r8
        new Word(Opcode.LDI, 1, -1, 0), 
        new Word(Opcode.STD, 1, -1, 20), //50 
        new Word(Opcode.LDI, 2, -1, 1),
        new Word(Opcode.STD, 2, -1, 21), //51
        new Word(Opcode.LDI, 0, -1, 22), //52
        new Word(Opcode.LDI, 6, -1, 6),
        new Word(Opcode.LDI, 7, -1, 31), //61
        new Word(Opcode.LDI, 3, -1, 0), 
        new Word(Opcode.ADD, 3, 1, -1),
        new Word(Opcode.LDI, 1, -1, 0), 
        new Word(Opcode.ADD, 1, 2, -1), 
        new Word(Opcode.ADD, 2, 3, -1),
        new Word(Opcode.STX, 0, 2, -1), 
        new Word(Opcode.ADDI, 0, -1, 1), 
        new Word(Opcode.SUB, 7, 0, -1),
        new Word(Opcode.JMPIG, 6, 7, -1), 
        new Word(Opcode.STOP, -1, -1, -1) };






    //        P2, um programa que le um valor de uma determinada posição (carregada no inicio),
    //        se o número for menor que zero coloca -1 no início da posição de memória para saída;
    //        se for maior que zero este é o número de valores da sequencia de fibonacci a
    //        serem escritos em sequencia a partir de uma posição de memoria;
    // fibonacci 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
    public Word[] fibonacci = new Word[]{
        new Word(Opcode.LDI,1,-1,10), // poe valor no r1														r1 =5
        new Word(Opcode.STD, 1,-1,50), // memoria[50] = r1
        new Word(Opcode.LDD, 7,-1,50), // r7 = memoria[50] ---- r7 vai ser o contador
        new Word(Opcode.LDI,0,-1,52), // r0=52
        new Word(Opcode.LDI, 4,-1, -1), // r4=-1
        new Word(Opcode.LDI,2,-1,27), // poe valor de pc para por o r1 na memoria de saida no r2			r2 = posicao de saida
        new Word(Opcode.JMPIL, 2,1,-1), // se r1<0 pula pra pc de r2, se nao continua						se r1<0, vai para a posicao de r2
    //se >0
        new Word(Opcode.LDI, 1, -1, 0),   // r1= 0
        new Word(Opcode.LDI, 2, -1, 1),   // r2= 1
        new Word(Opcode.LDI, 6, -1,28), // r6=pc do final
        new Word(Opcode.STD, 1,-1,50), // memoria[60] = r1
        new Word(Opcode.SUBI, 7, -1, 1),  // r7=r7-1
        new Word(Opcode.JMPIE, 6, 7, -1), // se r7==0 pc = r6
        new Word(Opcode.STD, 2,-1,51), // memoria[61] = r2
        new Word(Opcode.SUBI, 7, -1, 1),  // r7=r7-1

        new Word(Opcode.JMPIE, 6, 7, -1), // se r7==0 pc = r6
        new Word(Opcode.LDI, 4, -1, 16),  // r4 = 7
        new Word(Opcode.LDI, 3, -1, 0),  // r3=0
        new Word(Opcode.ADD, 3, 1, -1),  // r3=r3+r1
        new Word(Opcode.LDI, 1, -1, 0), // r1=0
        new Word(Opcode.ADD, 1, 2, -1), // r1=r1+r2
        new Word(Opcode.ADD, 2, 3, -1), // r2=r2+r3
        new Word(Opcode.STX, 0, 2, -1), // m[0] =r2
        new Word(Opcode.ADDI, 0, -1, 1), // r0 = r0+1
        new Word(Opcode.SUBI, 7, -1, 1),  // r7=r7-1
        new Word(Opcode.JMPIG, 4, 7, -1), // se r7>0 pc = r4
        new Word(Opcode.JMPIE, 6, 7, -1), // se r7==0 pc = r6

        new Word(Opcode.STD, 4,-1,50), // armazena na memoria 60 o valor do r4, no caso -1					MEMORIA[30] = r1

        new Word(Opcode.STOP,-1,-1,-1)
    };

    //	   P3: dado um inteiro em alguma posição de memória,
    //	   se for negativo armazena -1 na saída;
    //	   se for positivo responde o fatorial do número na saída
    //
    public Word[] fatorial = new Word[]{
        new Word(Opcode.LDI,1,-1,5), // poe valor no r1														r1 =5
        new Word(Opcode.STD, 1,-1,29), // memoria[29] = r1
        new Word(Opcode.LDD, 1,-1,29), // r1 = memoria[29]
        new Word(Opcode.LDI,2,-1,14), // poe valor de pc para por o r1 na memoria de saida no r2			r2 = posicao de saida

        new Word(Opcode.JMPIL, 2,1,-1), // se r1<0 pula pra pc de r2, se nao continua						se r1<0, vai para a posicao de r2

        new Word(Opcode.STD, 1,-1,30), // coloca o q ta no r1 na memoria 30									memoria[30] = r1
        new Word(Opcode.LDI,5,-1,30),  //poe em r5 a posicao da memoria										r5 = 30
        new Word(Opcode.LDX,2,5,-1), // r2 = m[30]															r2 = memoria[r5]
        new Word(Opcode.SUBI,2,-1,1), //r2=r2-1																r2 = r2-1 => fatorial(5 *(5-1))
        new Word(Opcode.LDI, 4,-1,8), // coloca no r4 o pc do inicio da multiplicacao						r4 = a posicao onde comeca o multiplicador
        // multiplica
        new Word(Opcode.MULT,1,2,-1), // multiplica r1,r2													r1= r*2
        new Word(Opcode.SUBI,2,-1,1), // r2=r2-1															r2--
        new Word(Opcode.JMPIG,4,2,-1), // se r2>0 entao pula pra r4, no inicio da multi						if(r2>0) go to r4 (MULT)

        new Word(Opcode.LDI, 4,-1,15), // coloca no r4 o pc do fim											r4 = posicao do final
        new Word(Opcode.STD,1,-1,30), // coloca o q ta em r1 em 30											MEMORIA[30] = r1
        new Word(Opcode.JMPIE,4,3,-1), // se r3==0 entao pula pra r4, no inicio da multi   					r3 =0 , if(r3==0) pula pro final (r4)
        new Word(Opcode.LDI,1,-1,-1), // coloca -1 em r1
        //			final
        new Word(Opcode.STD, 1,-1,30), // armazena na memoria 0 o valor do r1, no caso -1					MEMORIA[30] = r1
        new Word(Opcode.STOP, -1,-1,-1)																		// fim do programa
    };


    //	para um N definido (5 por exemplo)
    //	o programa ordena um vetor de N números em alguma posição de memória;
    //	ordena usando bubble sort
    //	loop ate que não swap nada
    //	passando pelos N valores
    //	faz swap de vizinhos se da esquerda maior que da direita

    //	bubble sort
    //		for(i = 0; i<5; i++){			//
    //		for(int j = 0; j<4; j++){		//
    //			if(vet[j] > vet[j + 1]){	// se m[0] > m[1]
    //				aux = vet[j];			// swap(m[0],m[1])
    //				vet[j] = vet[j+1];		//
    //				vet[j+1] = aux;			//
    //			}
    //		}
    //	}
    public Word[] bubbleSortvet5 = new Word[]{ //populando na memoria
        new Word(Opcode.LDI, 1, -1, 5), //colocando o valor 5 na posicao 60 da memoria, porem vamos considerar como [0]
        new Word(Opcode.STD, 1, -1, 60), //[0] = 5
        new Word(Opcode.LDI, 1, -1, 2),
        new Word(Opcode.STD, 1, -1, 61), //[1] = 2
        new Word(Opcode.LDI, 1, -1, 3),
        new Word(Opcode.STD, 1, -1, 62), //[2] = 3
        new Word(Opcode.LDI, 1, -1, 6),
        new Word(Opcode.STD, 1, -1, 63), //[3] = 6
        new Word(Opcode.LDI, 1, -1, 1),
        new Word(Opcode.STD, 1, -1, 64), //[4] = 1

        new Word(Opcode.LDI, 1, -1, 60), // passando a posicao [0] p/ o registrador 1 o inicio do vetor
        new Word(Opcode.STD, 1, -1, 50), // marcando o incio do vetor em memoria
        new Word(Opcode.STD, 1, -1, 51), // i = incio do vetor em memoria
        new Word(Opcode.STD, 1, -1, 52), // j = incio do vetor em memoria
        new Word(Opcode.LDI, 1, -1, 61),  // j+1 no r1
        new Word(Opcode.STD, 1, -1, 53), // j+1 no r1
        new Word(Opcode.LDI, 1, -1, 65),  // fim do vetor no r1
        new Word(Opcode.STD, 1, -1, 54), // marcando o final do vetor em memoria
        // inicio for i =0 i<5 i++
        new Word(Opcode.LDD, 1, -1, 51), // i = posicao do vet
        // inicio for j =0 j<4 i++
        new Word(Opcode.LDD, 2, -1, 52), // passando a posicao [0] p/ o registrador 2 j=0 --20
        new Word(Opcode.LDD, 3, -1, 53), // passando a posicao [1] p/ o registrador 3 j+1
    //			   condicional
        new Word(Opcode.LDX, 4, 2, -1), // passando dado de j para variaver r4
        new Word(Opcode.LDX, 5, 3, -1), // passando dado de j+1 para variaver r5
        new Word(Opcode.SUB, 4, 5, -1), // sendo r4 j e r5 j+1, se o resultado for positivo, deve ser trocado (3-2=1 (swap), 1-3=-2)
        new Word(Opcode.LDI, 5, -1, 31), // passa para r5 posicao de onde o vetor e incrementa j
        new Word(Opcode.JMPIL, 5, 4, -1), //se r4 < 0 entao, pulamos para o passo r5 pulando a troca
        // troca
        new Word(Opcode.LDX, 4, 2, -1), //pegando da memoria o valor vet[j]
        new Word(Opcode.LDX, 5, 3, -1), //pegando da memoria o valor vet[j + 1]
        new Word(Opcode.SWAP, 4, 5, -1), // trocando os dados de r5 com os de r4
        new Word(Opcode.STX, 2, 4, -1), // armazenando valor novo em r2
        new Word(Opcode.STX, 3, 5, -1), // armazenando valor novo e r3
        // incrementa do j
        new Word(Opcode.ADDI, 2, -1, 1), //j++ -- pc 31
        new Word(Opcode.ADDI, 3, -1, 1), //(j+1)++
        new Word(Opcode.LDI, 6, -1, 21), // passa para r6 a posicao do inicio do condicional
        new Word(Opcode.LDD, 7, -1, 54), // passa ultima posicao do vetor p/ r7
        new Word(Opcode.SUB, 7, 3, -1), // subtrai o valor de r7 pelo de r3 (tamanhoVetor-(j+1))
        new Word(Opcode.JMPIG, 6, 7, -1),  // se r7>0 entao vetor ainta possui numeros, entao voltar p/ incio do condicional na var r6
        //incrementa do i
        new Word(Opcode.ADDI, 1, -1, 1), // i++
        new Word(Opcode.LDI, 6, -1, 19), // passa para r6 a posicao do inicio do loop de i
        new Word(Opcode.LDD, 7, -1, 54), // passa ultima posicao do vetor p/ r7
        new Word(Opcode.SUB, 7, 1, -1), // subtrai o valor de r7 pelo de r1
        new Word(Opcode.JMPIG, 6, 7, -1),  // se r7>0 entao vetor ainta possui numeros, entao voltar p/ incio do for de I na var r6
        new Word(Opcode.STOP, -1, -1, -1)
    };


    public Word[] trapIn = new Word[]{
            new Word(Opcode.LDI, 7,-1,1), // r[7] = 1 -- INPUT
            new Word(Opcode.TRAP,7,-1,9), // Aloca numero fornecido pelo usuario no registrador
            new Word(Opcode.STOP, -1,-1,-1)
    };
    public Word[] trapOut = new Word[]{
            new Word(Opcode.LDI, 7,-1,2), // r[7] = 2 -- OUTPUT
            new Word(Opcode.LDI, 8,-1,30), // r[8] = 30 -- Adicona numero 30 ao registrador
            new Word(Opcode.TRAP, 1,-1,8), // Printa o numero 30 presente no registrador
            new Word(Opcode.STOP, -1,-1,-1)
    };

}