package view;

import model.acomodacoes.*;
import model.enums.*;
import model.itensCosumo.*;
import model.pessoas.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.*;

// Definição da classe Hotel
public class Hotel {

  // Atributos da classe
  private Pessoa usuario;

  private Object[] funcoesCadastro;
  private Object[] funcoesEditar;
  private Object[] funcoesRemover;
  private Object[] funcoesVizualizar;
  private Object[] funcoesDefault;

  private final List<Administrador> administradores;
  private final List<Hospede> hospedes;
  private final List<Funcionario> funcionarios;

  private final List<ItensConsumo> itensConsumoDisponiveis;

  private final List<Acomodacao> acomodacoesDisponiveis;
  private final List<TipoAcomodacao> tiposAcomodacao;

  private final List<Reserva> reservas;
  private final List<Acomodado> acomodados;

  private final Object[] estados = Estados.values();

  private final NiveisAcesso niveisAcesso;
  private final Menus menus;

  // Construtor da classe Hotel
  public Hotel() {
    // Inicialização das listas e chamada do método defaultValues()
    administradores = new ArrayList<>(5);
    hospedes = new ArrayList<>(100);
    funcionarios = new ArrayList<>(10);

    itensConsumoDisponiveis = new ArrayList<>(100);

    acomodacoesDisponiveis = new ArrayList<>(100);
    tiposAcomodacao = new ArrayList<>(10);

    reservas = new ArrayList<>(100);
    acomodados = new ArrayList<>(100);

    niveisAcesso = new NiveisAcesso();
    menus = new Menus();

    funcoesCadastro = new Object[]{};
    funcoesEditar = new Object[]{};
    funcoesRemover = new Object[]{};
    funcoesVizualizar = new Object[]{};
    funcoesDefault = new Object[]{};

    defaultValues();
  }

  // Método para iniciar o hotel
  public void init() {
    String opcao = "";
    String title = "Hotel";
    boolean quit = false;

    while (!quit) {

      int escolha;

      // Opções de acesso
      Object[] acessos = {
              "Sair",
              "Hospede",
              "Funcionario",
              "Administrador" };

      while (niveisAcesso.getNivelAcesso() <= 0){
        // Janela de diálogo para escolher o acesso
        escolha = JOptionPane.showOptionDialog(null, "Escolha um acesso", title, JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, acessos, acessos[1]);
        usuario = niveisAcesso.nivelAcesso(escolha, usuario, administradores, funcionarios);
        if (niveisAcesso.getNivelAcesso() == -1) {
          quit = true;
        }
      }

      // Loop enquanto a opção não for "Sair" e o nível de acesso for maior que 0
      while (!opcao.equals("Sair") && niveisAcesso.getNivelAcesso() > 0) {
        // Opções específicas de acordo com o nível de acesso

        funcoesVizualizar = niveisAcesso.functionsVizualizar();
        funcoesCadastro = niveisAcesso.functionsCadastro();
        funcoesEditar = niveisAcesso.functionsEditar();
        funcoesRemover = niveisAcesso.functionsRemover();
        funcoesDefault = niveisAcesso.functionsDefault();

        Object[] questions = hotelMenu();

        // Janela de diálogo para escolher uma opção, entre Cadastros, Editar, Remover, Vizualizar e Sair
        opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma opcao", title, JOptionPane.QUESTION_MESSAGE,
                null, questions, questions[0]);

        // Execução da opção escolhida
        boolean voltar = false;
        voltar = menus.menu(opcao, usuario,
                hospedes, administradores,
                funcionarios, reservas,
                acomodados, itensConsumoDisponiveis,
                tiposAcomodacao, acomodacoesDisponiveis,
                funcoesCadastro, funcoesEditar, funcoesRemover, funcoesVizualizar,
                estados, niveisAcesso.getNivelAcesso());
        if (voltar) {
          niveisAcesso.setNivelAcesso(0);
        }
      }
    }
  }

  private Object[] hotelMenu(){
    Object[] questions;

    if (usuario == null){
      questions = funcoesDefault;
    } else {
      questions = new Object[]{
              "Cadastros",
              "Editar",
              "Remover",
              "Vizualizar",
              "Funcoes padrao",
              "Voltar",
              "Sair"
      };
    }

    return questions;
  }

  // Método para configurar valores padrão
  private void defaultValues(){
    // Cadastrar administradores
    administradores.add(new Administrador("Igor", 16992479541L, "Ibaté", Estados.SP, LocalDate.parse("2005-04-18")));
    usuario = administradores.getFirst();

    // Cadastrar funcionários
    if (usuario instanceof Administrador administrador){
      administrador.cadastrarFuncionario("Caua", 123456789, "Araraquara", Estados.SP, LocalDate.parse("2005-03-16"), funcionarios);
      administrador.cadastrarFuncionario("Pedro", 123456789, "São Carlos", Estados.SP, LocalDate.parse("2003-08-21"), funcionarios);
      administrador.cadastrarFuncionario("Eduardo", 123456789, "Araraquara", Estados.SP, LocalDate.parse("2005-07-12"), funcionarios);
    }

    // Cadastrar hóspedes
    if (usuario instanceof Funcionario funcionario){
      funcionario.cadastrarHospede(new Hospede("João", 123456789, "Araraquara", Estados.SP, LocalDate.parse("2005-03-16"),
              "Brasil", "joao@gmail.com", TipoDoc.CPF, 123456789, "Maria", "José"), hospedes);
      funcionario.cadastrarHospede(new Hospede("Maria", 123456789, "São Carlos", Estados.SP, LocalDate.parse("2003-08-21"),
              "Brasil", "maria@gmail.com", TipoDoc.RG, 123456789, "João", "José"), hospedes);
      funcionario.cadastrarHospede(new Hospede("José", 123456789, "Araraquara", Estados.SP, LocalDate.parse("2005-07-12"),
              "Brasil", "jose@gmail.com", TipoDoc.PASSAPORTE, 123456789, "Maria", "João"), hospedes);
    }

    // Cadastrar itens de consumo
    itensConsumoDisponiveis.add(new ItensConsumo(1, TipoItens.FRIGOBAR, "Coca-cola", 8.00));
    itensConsumoDisponiveis.add(new ItensConsumo(2, TipoItens.FRIGOBAR, "Pepsi", 5.00));
    itensConsumoDisponiveis.add(new ItensConsumo(3, TipoItens.FRIGOBAR, "Guaraná", 6.00));
    itensConsumoDisponiveis.add(new ItensConsumo(4, TipoItens.LAVANDERIA, "Veja", 5.00));
    itensConsumoDisponiveis.add(new ItensConsumo(5, TipoItens.LAVANDERIA, "Omo", 7.00));
    itensConsumoDisponiveis.add(new ItensConsumo(6, TipoItens.LAVANDERIA, "Ariel", 2.00));
    itensConsumoDisponiveis.add(new ItensConsumo(7, TipoItens.RESTAURANTE, "Macarrao", 1.00));
    itensConsumoDisponiveis.add(new ItensConsumo(8, TipoItens.RESTAURANTE, "Arroz", 8.00));
    itensConsumoDisponiveis.add(new ItensConsumo(9, TipoItens.RESTAURANTE, "Feijao", 2.00));


    // Cadastrar tipos de acomodação
    tiposAcomodacao.add(new TipoAcomodacao(1, "Quarto", "Quarto com cama de casal", 10, 100.00, 2, 0));
    tiposAcomodacao.add(new TipoAcomodacao(2, "Quarto", "Quarto com cama de solteiro", 10, 100.00, 1, 0));
    tiposAcomodacao.add(new TipoAcomodacao(3, "Quarto", "Quarto com cama de solteiro", 10, 100.00, 1, 0));

  }
}
