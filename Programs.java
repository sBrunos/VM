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