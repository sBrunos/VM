
public class CPU {
    private int pc; // ... composto de program counter,
    private Word ir; // instruction register,
    private int[] reg; // registradores da CPU

    private Word[] m; // CPU acessa MEMORIA, guarda referencia 'm' a ela. memoria nao muda. ee sempre
                      // a mesma.

    public CPU(Word[] _m) { // ref a MEMORIA e interrupt handler passada na criacao da CPU
        m = _m; // usa o atributo 'm' para acessar a memoria.
        reg = new int[8]; // aloca o espaço dos registradores
    }

    public void setContext(int _pc) { // no futuro esta funcao vai ter que ser
        pc = _pc; // limite e pc (deve ser zero nesta versao)
    }

    public void run() { 		// execucao da CPU supoe que o contexto da CPU, vide acima, esta devidamente setado
			while (true) { 			// ciclo de instrucoes. acaba cfe instrucao, veja cada caso.
				// FETCH
					ir = m[pc]; 	// busca posicao da memoria apontada por pc, guarda em ir
				// EXECUTA INSTRUCAO NO ir
                    //#region Switch

					switch (ir.opc) { // para cada opcode, sua execução
                /////////////////////// JUMP /////////////////////
                    case JMP: // PC ← k
                        pc = ir.p;
                        break;

                    case JMPI: // PC ← Rs
                        pc = reg[ir.r1];
                        break;

                    case JMPIG: // If Rc > 0 Then PC ← Rs Else PC ← PC +1
                        if (reg[ir.r2] > 0) {
                            pc = reg[ir.r1];
                        } else {
                            pc++;
                        }
                        break;

                
                    case JMPIE: 
                        if(ir.r2 == 0){
                            pc = ir.r1;
                        }
                        else{
                            pc++;
                        }
                        break;

                    case JMPIM: 
                        pc = m[ir.p].p;

                        break;

                    case JMPIGM: 
                        if(ir.r2 > 0){
                            pc = m[ir.p].p;
                        }
                        else{
                            pc++;
                        }
                        break;
                    
                    
                    case JMPILM: 
                        if(ir.r2 < 0){
                            pc = m[ir.p].p;
                        }
                        else{
                            pc++;
                        }
                        break;

                    case JMPIEM:
                        if(ir.r2 == 0){
                            pc = m[ir.p].p;
                        }
                        else{
                            pc++;
                        }
                        break;
                
                    case STOP: // por enquanto, para execucao
                        break;



                    /////////////////////// ARITMÉTICAS /////////////////////
                    

                    case ADDI: // Rd ← Rd + k
                        reg[ir.r1] = reg[ir.r1] + ir.p;
                        pc++;
                        break;

                    case SUBI: // Rd ← Rd - Rs
                        reg[ir.r1] = reg[ir.r1] - reg[ir.p];
                        pc++;
                        break;

                    case ADD: // Rd ← Rd + Rs
                        reg[ir.r1] = reg[ir.r1] + reg[ir.r2];
                        pc++;
                        break;

                    case SUB: // Rd ← Rd - Rs
                        reg[ir.r1] = reg[ir.r1] - reg[ir.r2];
                        pc++;
                        break;

                    case MULT: // Rd ← Rd - Rs
                        reg[ir.r1] = reg[ir.r1] * reg[ir.r2];
                        pc++;
                        break;

                    /////////////////////// MOVIMETAÇÃO /////////////////////

                    case LDI: // Rd ← k
                        reg[ir.r1] = ir.p;
                        pc++;
                        break;

                    case LDD: // Rd ← k
                        reg[ir.r1] = m[ir.p].p;
                        pc++;
                        break;

                    case STD: // [A] ← Rs
                            m[ir.p].opc = Opcode.DATA;
                            m[ir.p].p = reg[ir.r2];
                            pc++;
                        break;

                    case LDX: 
                        reg[ir.r1] = m[ir.r2].p;
                        pc++;
                        break;

                    case STX: // [Rd] ←Rs
                            m[reg[ir.r1]].opc = Opcode.DATA;      
                            m[reg[ir.r1]].p = reg[ir.r2];          
                            pc++;
                        break;


                    case SWAP: // 
                            int aux = reg[ir.r1];
                            reg[ir.r1] = reg[ir.r2];
                            reg[ir.r1] = aux;
                            pc++;
                        break;

					
//#endregion

            }
				// VERIFICA INTERRUPÇÃO !!! - TERCEIRA FASE DO CICLO DE INSTRUÇÕES
				if (ir.opc==Opcode.STOP) {   
					break; // break sai do loop da cpu
				}
			}
		}
    }