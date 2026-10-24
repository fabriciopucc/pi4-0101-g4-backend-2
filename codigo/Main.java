public class Main {

    public static void main(String[] args){

        Prestador prestador = new Prestador();

        // NOME DO PRESTADOR
        prestador.setNomePrestador(
            lerTexto("Digite o nome do prestador: ")
        );

        // CATEGORIAS DO PRESTADOR
        String[] categoriasDisponiveis = {
            "Elétrica",
            "Hidráulica",
            "Pintura",
            "Alvenaria",
            "Limpeza",
            "Jardinagem",
            "Marcenaria",
            "Montagem de móveis"
        };

        System.out.println("\n---------- CATEGORIAS DISPONÍVEIS ----------");

        for(int i = 0; i < categoriasDisponiveis.length; i++){
            System.out.println(
                (i + 1) + " - " + categoriasDisponiveis[i]
            );
        }

        int quantidade = lerInteiro(
            "Quantas categorias deseja selecionar? (1 a 4): ",
            1,
            4
        );

        String[] categorias = new String[quantidade];

        for(int i = 0; i < quantidade; i++){

            while(true){

                int opcao = lerInteiro(
                    "Escolha a categoria " + (i + 1) + " (1 a 8): ",
                    1,
                    8
                );

                String categoria = categoriasDisponiveis[opcao - 1];

                boolean repetida = false;

                for(int j = 0; j < i; j++){
                    if(categoria.equals(categorias[j])){
                        repetida = true;
                        break;
                    }
                }

                if(repetida){
                    System.out.println(
                        "Erro: você já selecionou a categoria " + categoria + "."
                    );

                    continuarOuSair();

                }else{
                    categorias[i] = categoria;

                    System.out.println(
                        "Categoria selecionada: " + categoria
                    );

                    break;
                }
            }
        }

        prestador.SetCategorias(categorias);

        // VALOR POR HORA
        prestador.setValorHora(
            lerInteiro(
                "\nDigite o valor por hora (R$ 50 a R$ 1000): ",
                50,
                1000
            )
        );

        // HORAS E MINUTOS
        int horas = lerInteiro(
            "Digite a quantidade de horas inteiras: ",
            0,
            Integer.MAX_VALUE - 1
        );

        int minutos = lerInteiro(
            "Digite os minutos adicionais (0 a 59): ",
            0,
            59
        );

        prestador.setHorasContratadas(horas, minutos);

        System.out.println("\nCadastro realizado com sucesso!");

        mostrarMenu(prestador, horas, minutos);
    }

    // MENU DE CONSULTAS
    private static void mostrarMenu(
        Prestador prestador, int horas, int minutos
    ){

        while(true){

            System.out.println("\n========== QUEMRESOLVE ==========");
            System.out.println("Prestador: " + prestador.getNomePrestador());
            System.out.println("1 - Consultar dados do prestador");
            System.out.println("2 - Consultar categorias");
            System.out.println("3 - Consultar valor do serviço");
            System.out.println("4 - Mostrar resumo completo");
            System.out.println("0 - Sair");
            System.out.println("================================");

            int opcao = lerInteiro("Escolha uma opção: ", 0, 4);

            switch(opcao){

                case 1:
                    mostrarDados(prestador);
                    break;

                case 2:
                    mostrarCategorias(prestador);
                    break;

                case 3:
                    mostrarValorServico(prestador, horas, minutos);
                    break;

                case 4:
                    mostrarDados(prestador);
                    mostrarCategorias(prestador);
                    mostrarValorServico(prestador, horas, minutos);
                    break;

                case 0:
                    System.out.println("\nPrograma encerrado.");
                    return;
            }
        }
    }

    // MOSTRA OS DADOS DO PRESTADOR
    private static void mostrarDados(Prestador prestador){

        System.out.println("\n---------- PRESTADOR ----------");
        System.out.println("ID: " + prestador.getPrestadorId());
        System.out.println("Nome: " + prestador.getNomePrestador());

        System.out.printf(
            "Valor por hora: R$ %.2f%n",
            prestador.getValorHora()
        );
    }

    // MOSTRA AS CATEGORIAS CADASTRADAS
    private static void mostrarCategorias(Prestador prestador){

        System.out.println("\n---------- CATEGORIAS ----------");

        String[] categorias = prestador.getCategorias();

        for(int i = 0; i < categorias.length; i++){
            System.out.println((i + 1) + " - " + categorias[i]);
        }
    }

    // MOSTRA O TEMPO E O VALOR DO SERVIÇO
    private static void mostrarValorServico(
        Prestador prestador, int horas, int minutos
    ){

        System.out.println("\n---------- VALOR DO SERVIÇO ----------");

        System.out.println(
            "Tempo informado: " + horas + "h e " + minutos + "min"
        );

        System.out.println(
            "Horas cobradas: " + prestador.getHorasContratadas()
        );

        System.out.printf(
            "Valor por hora: R$ %.2f%n",
            prestador.getValorHora()
        );

        System.out.printf(
            "Total estimado: R$ %.2f%n",
            prestador.calcularTotalContrato()
        );
    }

    // LE TEXTO E PERMITE TENTAR NOVAMENTE OU SAIR
    private static String lerTexto(String pergunta){

        while(true){

            String entrada = IO.readln(pergunta);

            if(entrada == null){
                System.out.println("\nA entrada do terminal foi encerrada.");
                System.exit(0);
            }

            entrada = entrada.trim();

            if(entrada.length() > 0){
                return entrada;
            }

            System.out.println("Erro: o campo não pode ficar vazio.");

            continuarOuSair();
        }
    }

    // LE UM INTEIRO DENTRO DOS LIMITES INFORMADOS
    private static int lerInteiro(
        String pergunta, int minimo, int maximo
    ){

        while(true){

            String entrada = lerTexto(pergunta);

            try{
                int numero = Integer.parseInt(entrada);

                if(numero < minimo){
                    System.out.println(
                        "Erro: o valor mínimo permitido é " + minimo + "."
                    );

                }else if(numero > maximo){
                    System.out.println(
                        "Erro: o valor máximo permitido é " + maximo + "."
                    );

                }else{
                    return numero;
                }

            }catch(NumberFormatException erro){
                System.out.println(
                    "Erro: digite um número inteiro válido dentro do limite do tipo int."
                );
            }

            continuarOuSair();
        }
    }

    // PERMITE DIGITAR NOVAMENTE OU ENCERRAR O PROGRAMA
    private static void continuarOuSair(){

        while(true){

            System.out.println("\n1 - Digitar novamente");
            System.out.println("0 - Sair");

            String opcao = IO.readln("Escolha uma opção: ");

            if(opcao == null){
                System.out.println("\nA entrada do terminal foi encerrada.");
                System.exit(0);
            }

            opcao = opcao.trim();

            if(opcao.equals("1")){
                System.out.println();
                return;
            }

            if(opcao.equals("0")){
                System.out.println("\nPrograma encerrado.");
                System.exit(0);
            }

            System.out.println("Opção inválida. Digite 1 ou 0.");
        }
    }
}