package view;

import model.pessoas.Administrador;
import model.pessoas.Funcionario;
import model.pessoas.Hospede;
import model.pessoas.Pessoa;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Definição da classe NiveisAcesso que gerencia os níveis de acesso a cada responsável
 */
public class NiveisAcesso {

  private int nivelAcesso;

  /**
   * Método dos níveis de acesso
   */
  public NiveisAcesso() {
    this.nivelAcesso = 0;
  }

  public Object[] functionsCadastro(){
    Object[] funcoesCadastro = new Object[0];

    if (nivelAcesso >= 3) {
      funcoesCadastro = new Object[]{
              "Cadastrar administrador",
              "Cadastrar funcionario",
              "Cadastrar tipo de acomodacao",
              "Cadastrar acomodacao",
      };
    }

    if (nivelAcesso >= 2) {

      Object[] funcoesFuncionario;
      Object[] auxFunctionsFUNC;

      funcoesFuncionario = new Object[]{
              "Cadastrar reserva",
              "Cadastrar acomodado",
              "Cadastrar item de consumo",
              "Cadastrar consumo",
              "Cadastrar hospede",
              "Voltar"
      };

      // Juntar a funcao de cadastro com as funcoes do funcionario
      auxFunctionsFUNC  = new Object[funcoesCadastro.length + funcoesFuncionario.length];
      System.arraycopy(funcoesCadastro, 0, auxFunctionsFUNC, 0, funcoesCadastro.length);
      System.arraycopy(funcoesFuncionario, 0, auxFunctionsFUNC, funcoesCadastro.length, funcoesFuncionario.length);

      funcoesCadastro = auxFunctionsFUNC;
    }

    return funcoesCadastro;
  }

  /**
   * Método que fornece ao funcionário editar algo do sistema
   * @return fução de edição
   */
  public Object[] functionsEditar(){
    Object[] funcoesEditar = new Object[0];


    if (nivelAcesso >= 3) {
      funcoesEditar = new Object[]{
              "Editar administrador",
              "Editar funcionario",
              "Editar tipo de acomodacao",
              "Editar acomodacao",
      };
    }

    if (nivelAcesso >= 2){
      Object[] funcoesFuncionario;
      Object[] AuxFunctionsFUNC;

      funcoesFuncionario = new Object[]{
              "Editar reserva",
              "Editar acomodado",
              "Editar item de consumo",
              "Editar consumo",
              "Editar hospede",
              "Voltar"
      };

      AuxFunctionsFUNC = new Object[funcoesEditar.length + funcoesFuncionario.length];
      System.arraycopy(funcoesEditar, 0, AuxFunctionsFUNC, 0, funcoesEditar.length);
      System.arraycopy(funcoesFuncionario, 0, AuxFunctionsFUNC, funcoesEditar.length, funcoesFuncionario.length);

      funcoesEditar = AuxFunctionsFUNC;
    }

    return funcoesEditar;
  }

  /**
   * Método que permite o funcionario remover algo do sistema
   * @return função de remover
   */
  public Object[] functionsRemover(){
    Object[] funcoesRemover = new Object[0];

    if (nivelAcesso >= 3) {
      funcoesRemover = new Object[]{
              "Remover administrador",
              "Remover funcionario",
              "Remover tipo de acomodacao",
              "Remover acomodacao",
      };
    }

    if (nivelAcesso >= 2) {
      Object[] funcoesFuncionario;
      Object[] AuxFunctionsFUNC;

      funcoesFuncionario = new Object[]{
              "Remover reserva",
              "Remover acomodado",
              "Remover item de consumo",
              "Remover consumo",
              "Remover hospede",
              "Voltar"
      };

      AuxFunctionsFUNC = new Object[funcoesRemover.length + funcoesFuncionario.length];
      System.arraycopy(funcoesRemover, 0, AuxFunctionsFUNC, 0, funcoesRemover.length);
      System.arraycopy(funcoesFuncionario, 0, AuxFunctionsFUNC, funcoesRemover.length, funcoesFuncionario.length);

      funcoesRemover = AuxFunctionsFUNC;
    }

    return funcoesRemover;
  }

  /**
   * Método que permite o funcionario realizar a visualização do sistema
   * @return função de vizualizar
   */
  public Object[] functionsVizualizar(){
    Object[] funcoesVizualizar = new Object[0];

    if (nivelAcesso >= 3) {
      funcoesVizualizar = new Object[]{
              "Ver administradores",
              "Ver funcionarios",
              "Ver tipos de acomodacao",
              "Ver acomodacoes",
      };
    }

    if (nivelAcesso >= 2) {
      Object[] funcoesFuncionario;
      Object[] AuxFunctionsFUNC;

      funcoesFuncionario = new Object[]{
              "Ver reservas",
              "Ver acomodados",
              "Ver itens de consumo",
              "Ver hospedes",
              "Voltar"
      };

      AuxFunctionsFUNC = new Object[funcoesVizualizar.length + funcoesFuncionario.length];
      System.arraycopy(funcoesVizualizar, 0, AuxFunctionsFUNC, 0, funcoesVizualizar.length);
      System.arraycopy(funcoesFuncionario, 0, AuxFunctionsFUNC, funcoesVizualizar.length, funcoesFuncionario.length);

      funcoesVizualizar = AuxFunctionsFUNC;
    }

    return funcoesVizualizar;
  }

  /**
   * Método que permite o funcionario realizar a finalização da estadia ou cosumir um item
   * @return funcao default
   */
  public Object[] functionsDefault(){
    Object[] funcoesDefault = new Object[0];

      funcoesDefault = new Object[]{
              "Consumir",
              "Encerrar estadia",
              "Voltar",
      };

    return funcoesDefault;
  }

  /**
   * Método que gerencia o nível de acesso
   * @param acesso nível de acesso
   * @param usuario usuario a usar o sistema
   * @param administradores administradores
   * @param funcionarios funcionarios
   * @param hospedes hospedes
   * @return usuario a usar o sistema
   */
  public Pessoa nivelAcesso(int acesso, Pessoa usuario, List<Administrador> administradores, List<Funcionario> funcionarios, List<Hospede> hospedes) {
    switch (acesso) {
      case 2:
        usuario = ADMAccess(administradores, usuario);
        break;
      case 1:
        // Nível de acesso para funcionários
        usuario = FuncAccess(funcionarios, usuario);
        break;
      case 0:
        // Entrar como hóspede? Sim ou não
        usuario = HospedeAccess(hospedes, usuario);
        break;
      case 3:
        // Sair...
        nivelAcesso = -1;
        break;
    }

    return usuario;
  }

  /**
   * Método para entrar como administrador
   * @param administradores administradores
   * @param usuario usuario a usar o sistema
   * @return usuario acessado
   */
  private Pessoa ADMAccess(List<Administrador> administradores, Pessoa usuario) {
    String senha;

    if (administradores.isEmpty()) {
      JOptionPane.showMessageDialog(null, "Nao ha administradores cadastrados");
      Cadastros.cadastrarAdministrador(administradores, usuario);
    } else {
      // Selecionar qual administrador de acordo com o nome.
      Object[] nomes = new Object[administradores.size()];
      for (int i = 0; i < administradores.size(); i++) {
        nomes[i] = administradores.get(i).getNome();
      }

      String nome = (String) JOptionPane.showInputDialog(null, "Escolha um administrador", "Acesso de administrador", JOptionPane.QUESTION_MESSAGE, null, nomes, nomes[0]);

      if (nome == null) {
        return usuario;
      }

      Administrador adm = null;

      for (Administrador lista : administradores) {
        if (lista.getNome().equals(nome)) {
          adm = lista;
          usuario = adm;
          break;
        }
      }

      senha = JOptionPane.showInputDialog(null,
              "Digite a senha", "Acesso de administrador",
              JOptionPane.QUESTION_MESSAGE);

      if (senha == null) {
        return usuario;
      }

      assert adm != null;
      if (!adm.allowAccess(Integer.parseInt(senha))) {
        JOptionPane.showMessageDialog(null, "Senha incorreta");
      } else {
        nivelAcesso = 3;
        return usuario;
      }
    }

    return usuario;
  }

  /**
   * Método para entrar como funcionário
   * @param funcionarios funcionarios
   * @param usuario usuario a usar o sistema
   * @return usuario acessado
   */
  private Pessoa FuncAccess(List<Funcionario> funcionarios, Pessoa usuario) {
    String senha;

    if (funcionarios.isEmpty()) {
      JOptionPane.showMessageDialog(null, "Nao ha funcionarios cadastrados");
    } else {
      Object[] nomesFuncionarios = new Object[funcionarios.size()];
      for (int i = 0; i < funcionarios.size(); i++) {
        nomesFuncionarios[i] = funcionarios.get(i).getNome();
      }

      String nomeFuncionario = (String) JOptionPane.showInputDialog(null, "Escolha um funcionario",
              "Acesso de funcionario", JOptionPane.QUESTION_MESSAGE, null, nomesFuncionarios, nomesFuncionarios[0]);

      if (nomeFuncionario == null) {
        return usuario;
      }

      Funcionario func = null;

      for (Funcionario lista : funcionarios) {
        if (lista.getNome().equals(nomeFuncionario)) {
          func = lista;
          break;
        }
      }

      // Senha para entrar como funcionário
      senha = JOptionPane.showInputDialog(null, "Digite a senha", "Acesso de funcionario", JOptionPane.QUESTION_MESSAGE);

      if (senha == null || func == null) {
        return usuario;
      }
        
      if (!func.allowAccess(Integer.parseInt(senha))) {
        JOptionPane.showMessageDialog(null, "Senha incorreta");
      } else {
        nivelAcesso = 2;
        usuario = func;
        return usuario;
      }
    }
    return usuario;
  }

  /**
   * Método para entrar como hóspede
   * @param hospedes hospedes
   * @param usuario usuario a usar o sistema
   * @return acessado
   */
  private Pessoa HospedeAccess(List<Hospede> hospedes, Pessoa usuario) {
    String senha;

    if (hospedes.isEmpty()) {
      JOptionPane.showMessageDialog(null, "Nao ha hospedes cadastrados");
    } else {
      List<Hospede> hospedesAcomodados = new ArrayList<>(5);

      for (Hospede hospede : hospedes) {
        if (hospede.isAcomodado())
        {
          hospedesAcomodados.add(hospede);
        }
      }

      if (hospedesAcomodados.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Nao ha hospedes acomodados");
        return usuario;
      } else {
        Object[] nomesHospedes = new Object[hospedesAcomodados.size()];
        for (int i = 0; i < hospedes.size(); i++) {
          nomesHospedes[i] = hospedesAcomodados.get(i).getNome();
        }

        String nomeFuncionario = (String) JOptionPane.showInputDialog(null,
                "Quem é você?",
                "Acesso de funcionario", JOptionPane.QUESTION_MESSAGE, null,
                nomesHospedes,
                nomesHospedes[0]);

        if (nomeFuncionario == null) {
          return usuario;
        }

        Hospede hospede = null;

        for (Hospede lista : hospedes) {
          if (lista.getNome().equals(nomeFuncionario)) {
            hospede = lista;
            break;
          }
        }

        // Senha para entrar como funcionário
        senha = JOptionPane.showInputDialog(null, "Digite a senha", "Acesso de funcionario", JOptionPane.QUESTION_MESSAGE);

        if (senha == null || hospede == null) {
          return usuario;
        }

        if (!hospede.allowAccess(Integer.parseInt(senha))) {
          JOptionPane.showMessageDialog(null, "Senha incorreta");
        } else {
          nivelAcesso = 1;
          usuario = hospede;
          return usuario;
        }
      }
    }

    return usuario;
  }

  /**
   * Método de acesso ao nivel de acesso
   * @return nivel de acesso
   */
  public int getNivelAcesso() {
    return nivelAcesso;
  }

  /**
   * Método de modificação do nível de acesso
   * @param nivelAcesso nivel de acesso
   */
  public void setNivelAcesso(int nivelAcesso) {
    if (nivelAcesso < this.nivelAcesso)
      this.nivelAcesso = nivelAcesso;
  }
}
