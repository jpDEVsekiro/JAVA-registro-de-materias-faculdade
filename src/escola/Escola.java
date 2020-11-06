package escola;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.UnexpectedException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class Escola extends JFrame implements ActionListener {

    static ConnectionFactory conexao = new ConnectionFactory();
    JMenuBar barra = new JMenuBar();
    JMenu cadastrar = new JMenu("cadastrar");
    JMenu mostrar = new JMenu("mostrar");
    JMenu sair = new JMenu("sair");
    JMenuItem exit = new JMenuItem("exit");
    JMenuItem ccurso = new JMenuItem("curso");
    JMenuItem cdiciplina = new JMenuItem("diciplina");
    JMenuItem caluno = new JMenuItem("aluno");
    JMenuItem cprofessor = new JMenuItem("professor");
    JMenuItem mcurso = new JMenuItem("curso");
    JMenuItem mdiciplina = new JMenuItem("diciplina");
    JMenuItem maluno = new JMenuItem("aluno");
    JMenuItem mprofessor = new JMenuItem("professor");
    JMenuItem mcurso_professores = new JMenuItem("cursos/professors");
    JMenuItem mcurso_aluno = new JMenuItem("cursos/alunos");
    JMenuItem mcurso_diciplinas = new JMenuItem("cursos/diciplinas");
    JMenuItem mprofessores_diciplinas = new JMenuItem("professores/diciplinas");
    JMenuItem malunos_diciplinas = new JMenuItem("aluno/diciplina");
    JRadioButton rdbtn_1 = new JRadioButton("1");
    JRadioButton rdbtn_2 = new JRadioButton("2");
    JRadioButton rdbtn_3 = new JRadioButton("3");
    JRadioButton rdbtn_4 = new JRadioButton("4");
    JRadioButton rdbtn_5 = new JRadioButton("5");
    JRadioButton rdbtn_6 = new JRadioButton("6");
    JRadioButton bacharel = new JRadioButton("bacharel");
    JRadioButton gestao = new JRadioButton("gestão");
    JRadioButton outros = new JRadioButton("outros");
    JButton jbcadastrar = new JButton("", null);
    JButton jbexcluir = new JButton("excluir", null);
    JLabel jlcadastrar = new JLabel();
    JLabel nome = new JLabel();
    JTextField codcurso, ccodigo;
    JLabel resul, resulbd;
    JSpinner carga_hora;
    String nome_curso, tipo_cur, codebd, codf;
    JButton jbeditar;

    public static void main(String[] args) {
        JFrame f = new JFrame("faculdade");
        f.setSize(490, 612);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setLayout(null);
        Escola escola = new Escola(f);
    }

    public Escola(JFrame f) {
        f.setJMenuBar(barra);
        barra.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        barra.add(cadastrar);
        barra.add(mostrar);
        barra.add(sair);
        sair.add(exit);
        cadastrar.add(ccurso);
        cadastrar.add(cdiciplina);
        cadastrar.add(caluno);
        cadastrar.add(cprofessor);
        mostrar.add(mcurso);
        mostrar.add(mdiciplina);
        mostrar.add(maluno);
        mostrar.add(mprofessor);
        mcurso_professores.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
        mostrar.add(mcurso_professores);
        mostrar.add(mcurso_diciplinas);
        mostrar.add(mprofessores_diciplinas);
        mostrar.add(malunos_diciplinas);
        exit.addActionListener(this);
        ccurso.addActionListener(this);
        cprofessor.addActionListener(this);
        cdiciplina.addActionListener(this);
        caluno.addActionListener(this);
        mdiciplina.addActionListener(this);
        mcurso.addActionListener(this);
        maluno.addActionListener(this);
        mprofessor.addActionListener(this);
        mcurso_professores.addActionListener(this);
        mcurso_diciplinas.addActionListener(this);
        mprofessores_diciplinas.addActionListener(this);
        malunos_diciplinas.addActionListener(this);

    }

    public void cdiciplina(JFrame f) {
        f.setSize(490, 612);
        f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setLayout(null);
        JLabel cod_da_disc = new JLabel("<html><font size=3 color=rgb(0,0,0)> código diciplina:");
        JTextField ctcoddisc = new JTextField();
        f.add(cod_da_disc);
        cod_da_disc.setBounds(10, 8, 100, 13);
        f.add(ctcoddisc);
        ctcoddisc.setToolTipText("código da diciplina");
        ctcoddisc.setBounds(120, 6, 106, 20);
        ctcoddisc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        JLabel cnome_disc = new JLabel("<html><font size=3 color=rgb(0,0,0)> nome dá diciplina:");
        JTextField cnomedisc = new JTextField();
        f.add(cnome_disc);
        cnome_disc.setBounds(10, 40, 120, 13);
        f.add(cnomedisc);
        cnomedisc.setToolTipText("nome da diciplina");
        cnomedisc.setBounds(120, 38, 106, 20);
        cnomedisc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        JLabel ccarga_h = new JLabel("<html><font size=3 color=rgb(0,0,0)> carga horária:");
        JSpinner cspinnercargahoraria = new JSpinner(new SpinnerNumberModel(1, 1, 2020, 1));
        f.add(ccarga_h);
        ccarga_h.setBounds(10, 72, 120, 13);
        f.add(cspinnercargahoraria);
        cspinnercargahoraria.setToolTipText("carga horária");
        cspinnercargahoraria.setBounds(120, 70, 60, 20);
        cspinnercargahoraria.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        JLabel aulas_sem = new JLabel("<html><font size=3 color=rgb(0,0,0)> aulas semana:");
        f.add(aulas_sem);
        aulas_sem.setBounds(10, 104, 120, 13);
        f.add(rdbtn_1);
        f.add(rdbtn_2);
        f.add(rdbtn_3);
        f.add(rdbtn_4);
        f.add(rdbtn_5);
        f.add(rdbtn_6);
        rdbtn_1.setBounds(120, 102, 60, 20);
        rdbtn_2.setBounds(120, 122, 60, 20);
        rdbtn_3.setBounds(120, 142, 60, 20);
        rdbtn_4.setBounds(120, 162, 60, 20);
        rdbtn_5.setBounds(120, 182, 60, 20);
        rdbtn_6.setBounds(120, 202, 60, 20);
        rdbtn_1.addActionListener(this);
        rdbtn_2.addActionListener(this);
        rdbtn_3.addActionListener(this);
        rdbtn_4.addActionListener(this);
        rdbtn_5.addActionListener(this);
        rdbtn_6.addActionListener(this);
        JButton jbcadastrar = new JButton("", null);
        f.add(jbcadastrar);
        jbcadastrar.setBounds(334, 533, 150, 50);
        jbcadastrar.setBackground(new Color(138, 43, 226));
        JLabel jlbar = new JLabel("<html><font size=5 color=rgb(0,0,0)>");
        jlbar.setBackground(new Color(138, 43, 226));
        jlbar.setOpaque(true);
        f.add(jlbar);
        jbcadastrar.add(jlcadastrar);
        jbcadastrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 2, true));
        jlbar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 2, true));
        jlbar.setBounds(0, 533, 334, 50);
        jbcadastrar.addActionListener(this);
    }

    public void cdaluno(JFrame f) {
        f.setSize(490, 612);
        f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setLayout(null);
        JLabel num_matricula = new JLabel("<html><font size=3 color=rgb(0,0,0)> número de matricula:");
        JTextField cnum_matri = new JTextField();
        f.add(num_matricula);
        num_matricula.setBounds(10, 8, 125, 13);
        f.add(cnum_matri);
        cnum_matri.setToolTipText("numero de matricula");
        cnum_matri.setBounds(135, 6, 106, 20);
        cnum_matri.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        JLabel cnome_alu = new JLabel("<html><font size=3 color=rgb(0,0,0)> nome do aluno:");
        JTextField cnome_alun = new JTextField();
        f.add(cnome_alu);
        cnome_alu.setBounds(10, 40, 120, 13);
        f.add(cnome_alun);
        cnome_alun.setToolTipText("nome do aluno");
        cnome_alun.setBounds(135, 38, 106, 20);
        cnome_alun.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        JLabel date_nasc = new JLabel("<html><font size=3 color=rgb(0,0,0)> data de nascimento:");
        f.add(date_nasc);
        date_nasc.setBounds(10, 72, 120, 13);
        JSpinner cdia = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
        f.add(cdia);
        cdia.setToolTipText("dia");
        cdia.setBounds(135, 70, 40, 20);
        cdia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        JSpinner cmes = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
        f.add(cmes);
        cmes.setToolTipText("mes");
        cmes.setBounds(180, 70, 45, 20);
        cmes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        JSpinner cano = new JSpinner(new SpinnerNumberModel(2000, 1, 2020, 1));
        f.add(cano);
        cano.setToolTipText("ano");
        cano.setBounds(230, 70, 70, 20);
        cano.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        JLabel cod_curso = new JLabel("<html><font size=3 color=rgb(0,0,0)> código do curso:");
        JTextField codcurso = new JTextField();
        f.add(cod_curso);
        cod_curso.setBounds(10, 104, 100, 13);
        f.add(codcurso);
        codcurso.setToolTipText("código do curso");
        codcurso.setBounds(135, 102, 106, 20);
        codcurso.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        JLabel cnome_curso = new JLabel("<html><font size=3 color=rgb(0,0,0)> nome do curso:");
        JTextField cnome_cur = new JTextField();
        f.add(cnome_curso);
        cnome_curso.setBounds(10, 136, 120, 13);
        f.add(cnome_cur);
        cnome_cur.setToolTipText("nome do curso");
        cnome_cur.setBounds(135, 134, 106, 20);
        cnome_cur.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        JButton jbcadastrar = new JButton("", null);
        f.add(jbcadastrar);
        jbcadastrar.setBounds(334, 533, 150, 50);
        jbcadastrar.setBackground(new Color(138, 43, 226));
        JLabel jlbar = new JLabel("<html><font size=5 color=rgb(0,0,0)>");
        jlbar.setBackground(new Color(138, 43, 226));
        jlbar.setOpaque(true);
        f.add(jlbar);
        jbcadastrar.add(jlcadastrar);
        jbcadastrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 2, true));
        jlbar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 2, true));
        jlbar.setBounds(0, 533, 334, 50);
        jbcadastrar.addActionListener(this);
        String[] list = {"lpoo", "BD", "Estruturas de Dados", "engenharia de sogtware", "logica programação"};
        JList lista = new JList(list);
        lista.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        f.add(lista);
        lista.setBounds(10, 180, 200, 100);
    }

    public void cprof(JFrame f) {
        f.setSize(490, 612);
        f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setLayout(null);
        JLabel prof_indent = new JLabel("<html><font size=3 color=rgb(0,0,0)> indentificação do professor:");
        JTextField cprof_indent = new JTextField();
        f.add(prof_indent);
        prof_indent.setBounds(10, 8, 160, 13);
        f.add(cprof_indent);
        cprof_indent.setToolTipText("indentificação do professor");
        cprof_indent.setBounds(175, 6, 106, 20);
        cprof_indent.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        JLabel cnome_prof = new JLabel("<html><font size=3 color=rgb(0,0,0)> nome do professor:");
        JTextField cnome_profe = new JTextField();
        f.add(cnome_prof);
        cnome_prof.setBounds(10, 40, 120, 13);
        f.add(cnome_profe);
        cnome_profe.setToolTipText("nome do professor");
        cnome_profe.setBounds(175, 38, 106, 20);
        cnome_profe.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        JLabel crua = new JLabel("<html><font size=3 color=rgb(0,0,0)> rua:");
        JTextField cnome_rua = new JTextField();
        f.add(crua);
        crua.setBounds(10, 72, 120, 13);
        f.add(cnome_rua);
        cnome_rua.setToolTipText("rua");
        cnome_rua.setBounds(40, 70, 106, 20);
        cnome_rua.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        JLabel num_casa = new JLabel("<html><font size=3 color=rgb(0,0,0)> numero:");
        f.add(num_casa);
        num_casa.setBounds(150, 72, 120, 13);
        JSpinner cnum = new JSpinner(new SpinnerNumberModel(1, 1, null, 1));
        f.add(cnum);
        cnum.setToolTipText("numero");
        cnum.setBounds(200, 70, 70, 20);
        cnum.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        JLabel cbairro = new JLabel("<html><font size=3 color=rgb(0,0,0)> bairro:");
        JTextField cnome_bairro = new JTextField();
        f.add(cbairro);
        cbairro.setBounds(280, 72, 120, 13);
        f.add(cnome_bairro);
        cnome_bairro.setToolTipText("bairro");
        cnome_bairro.setBounds(320, 70, 106, 20);
        cnome_bairro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        JLabel ccidade = new JLabel("<html><font size=3 color=rgb(0,0,0)> cidade:");
        JTextField cidade = new JTextField();
        f.add(ccidade);
        ccidade.setBounds(10, 104, 120, 13);
        f.add(cidade);
        cidade.setToolTipText("cidade");
        cidade.setBounds(60, 102, 106, 20);
        cidade.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        JLabel cestado = new JLabel("<html><font size=3 color=rgb(0,0,0)> estado:");
        JTextField estado = new JTextField();
        f.add(cestado);
        cestado.setBounds(175, 104, 120, 13);
        f.add(estado);
        estado.setToolTipText("estado");
        estado.setBounds(220, 102, 106, 20);
        estado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        JLabel ctelfixo = new JLabel("<html><font size=3 color=rgb(0,0,0)> telefone fixo:");
        JTextField telfixo = new JTextField();
        f.add(ctelfixo);
        ctelfixo.setBounds(10, 136, 120, 13);
        f.add(telfixo);
        telfixo.setToolTipText("telefone fixo");
        telfixo.setBounds(85, 134, 106, 20);
        telfixo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        JLabel celular = new JLabel("<html><font size=3 color=rgb(0,0,0)> celular:");
        JTextField ccelular = new JTextField();
        f.add(celular);
        celular.setBounds(195, 136, 120, 13);
        f.add(ccelular);
        ccelular.setToolTipText("celular");
        ccelular.setBounds(240, 134, 106, 20);
        ccelular.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        JLabel date_nasc = new JLabel("<html><font size=3 color=rgb(0,0,0)> data de nascimento:");
        f.add(date_nasc);
        date_nasc.setBounds(10, 168, 120, 13);
        JSpinner cdia = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
        f.add(cdia);
        cdia.setToolTipText("dia");
        cdia.setBounds(135, 168, 40, 20);
        cdia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        JSpinner cmes = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
        f.add(cmes);
        cmes.setToolTipText("mes");
        cmes.setBounds(180, 168, 45, 20);
        cmes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        JSpinner cano = new JSpinner(new SpinnerNumberModel(2000, 1, 2020, 1));
        f.add(cano);
        cano.setToolTipText("ano");
        cano.setBounds(230, 168, 70, 20);
        cano.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        JLabel especificações = new JLabel("<html><font size=3 color=rgb(0,0,0)> especificações do professor:");
        JCheckBox espe_prof = new JCheckBox("portugues");
        JCheckBox espe_prof1 = new JCheckBox("informática");
        JCheckBox espe_prof2 = new JCheckBox("matemática");
        JCheckBox espe_prof3 = new JCheckBox("medicina");
        JCheckBox espe_prof4 = new JCheckBox("arquitetura");
        JCheckBox espe_prof5 = new JCheckBox("direito");
        f.add(espe_prof);
        f.add(espe_prof1);
        f.add(espe_prof2);
        f.add(espe_prof3);
        f.add(espe_prof4);
        f.add(espe_prof5);
        f.add(especificações);
        especificações.setBounds(10, 202, 170, 20);
        espe_prof.setBounds(10, 225, 170, 20);
        espe_prof1.setBounds(10, 245, 170, 20);
        espe_prof2.setBounds(10, 265, 170, 20);
        espe_prof3.setBounds(10, 285, 170, 20);
        espe_prof4.setBounds(10, 305, 170, 20);
        espe_prof5.setBounds(10, 325, 170, 20);
        JLabel titulo = new JLabel("<html><font size=3 color=rgb(0,0,0)> titulo professor:");
        f.add(titulo);
        JCheckBox titulo_prof1 = new JCheckBox("Bacharel");
        JCheckBox titulo_prof2 = new JCheckBox("Especialista Lato Sensu");
        JCheckBox titulo_prof3 = new JCheckBox("Mestrado");
        JCheckBox titulo_prof4 = new JCheckBox("Doutorado");
        f.add(titulo_prof1);
        f.add(titulo_prof2);
        f.add(titulo_prof3);
        f.add(titulo_prof4);
        titulo.setBounds(10, 357, 170, 20);
        titulo_prof1.setBounds(10, 380, 170, 20);
        titulo_prof2.setBounds(10, 400, 170, 20);
        titulo_prof3.setBounds(10, 420, 170, 20);
        titulo_prof4.setBounds(10, 440, 170, 20);
        JButton jbcadastrar = new JButton("", null);
        f.add(jbcadastrar);
        jbcadastrar.setBounds(334, 535, 150, 50);
        jbcadastrar.setBackground(new Color(138, 43, 226));
        JLabel jlbar = new JLabel("<html><font size=5 color=rgb(0,0,0)>");
        jlbar.setBackground(new Color(138, 43, 226));
        jlbar.setOpaque(true);
        f.add(jlbar);
        jbcadastrar.add(jlcadastrar);
        jbcadastrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 2, true));
        jlbar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 2, true));
        jlbar.setBounds(0, 535, 334, 50);
        jbcadastrar.addActionListener(this);
    }

    public void ccurso(JFrame f) {
        f.setSize(490, 612);
        f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setLayout(null);
        JLabel cod_curso = new JLabel("<html><font size=3 color=rgb(0,0,0)> código do curso:");
        codcurso = new JTextField();
        f.add(cod_curso);
        cod_curso.setBounds(10, 8, 100, 13);
        f.add(codcurso);
        codcurso.setToolTipText("código do curso");
        codcurso.setBounds(120, 6, 106, 20);
        codcurso.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        JLabel cnome = new JLabel("<html><font size=5 color=rgb(0,0,0)> nome do curso:");
        f.add(cnome);
        cnome.setBounds(10, 40, 200, 20);
        String[] list = {"Administração de Empresas", "BioMedicina", "Ciências Biológicas", "Ciencias da Computação", "Direito", "Educação Física", "Farmacologia", "Rede de Computadores", "Sistemas de Informações", "Arquitetura e Urbanismo", "Ciência de Dados"};
        JList lista = new JList(list);
        lista.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        f.add(lista);
        lista.setBounds(10, 80, 400, 200);
        nome_curso = "";
        tipo_cur = "";
        lista.addListSelectionListener(e -> {
            int index = lista.getSelectedIndex();
            if (index == 0) {
                nome_curso = list[0];
            } else if (index == 1) {
                nome_curso = list[1];
            } else if (index == 2) {
                nome_curso = list[2];
            } else if (index == 3) {
                nome_curso = list[3];
            } else if (index == 4) {
                nome_curso = list[4];
            } else if (index == 5) {
                nome_curso = list[5];
            } else if (index == 6) {
                nome_curso = list[6];
            } else if (index == 7) {
                nome_curso = list[7];
            } else if (index == 8) {
                nome_curso = list[8];
            } else if (index == 9) {
                nome_curso = list[9];
            } else if (index == 10) {
                nome_curso = list[10];
            }
        });
        JLabel tipo_curso = new JLabel("<html><font size=5 color=rgb(0,0,0)>tipo de curso:");
        f.add(tipo_curso);
        tipo_curso.setBounds(10, 295, 150, 20);
        f.add(bacharel);
        f.add(gestao);
        f.add(outros);
        bacharel.setSelected(false);
        outros.setSelected(false);
        gestao.setSelected(false);
        bacharel.setBounds(10, 320, 100, 20);
        gestao.setBounds(10, 350, 100, 20);
        outros.setBounds(10, 380, 100, 20);
        bacharel.addActionListener(this);
        gestao.addActionListener(this);
        outros.addActionListener(this);
        JLabel codigo_intituto = new JLabel("<html><font size=5 color=rgb(0,0,0)> código instituto:");
        ccodigo = new JTextField();
        f.add(codigo_intituto);
        codigo_intituto.setBounds(10, 410, 160, 22);
        f.add(ccodigo);
        ccodigo.setToolTipText(" código instituto");
        ccodigo.setBounds(10, 440, 106, 20);
        ccodigo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        JLabel carga_horaria = new JLabel("<html><font size=5 color=rgb(0,0,0)> carga horária:");
        f.add(carga_horaria);
        carga_horaria.setBounds(10, 465, 200, 23);
        carga_hora = new JSpinner(new SpinnerNumberModel(1, 1, null, 1));
        f.add(carga_hora);
        carga_hora.setToolTipText("carga horária");
        carga_hora.setBounds(10, 490, 80, 20);
        carga_hora.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        f.add(jbcadastrar);
        jbcadastrar.setBounds(334, 535, 150, 50);
        jbcadastrar.setBackground(new Color(138, 43, 226));
        JLabel jlbar = new JLabel("<html><font size=5 color=rgb(0,0,0)>");
        jlbar.setBackground(new Color(138, 43, 226));
        jlbar.setOpaque(true);
        f.add(jlbar);
        jbcadastrar.add(jlcadastrar);
        jbcadastrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 2, true));
        jlbar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 2, true));
        jlbar.setBounds(0, 535, 334, 50);
        jbcadastrar.addActionListener(this);
    }

    public void curso_prof(JFrame f) {
        f.setSize(490, 612);
        f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setLayout(null);
        JLabel cnome = new JLabel("<html><font size=5 color=rgb(0,0,0)> nome do curso:");
        f.add(cnome);
        cnome.setBounds(10, 40, 200, 20);
        String[] list = {"Administração de Empresas", "BioMedicina", "Ciências Biológicas", "Ciencias da Computação", "Direito", "Educação Física", "Farmacologia", "Rede de Computadores", "Sistemas de Informações", "Arquitetura e Urbanismo", "Ciência de Dados"};
        JList lista = new JList(list);
        lista.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        f.add(lista);
        lista.setBounds(10, 80, 400, 200);
        lista.addListSelectionListener(e -> {
            int index = lista.getSelectedIndex();
            if (index == 0) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> professores:Abel, Abílio, Abreu, Adaílton,Balbino, Baltazar, Basileu, Barbara, Beatriz, Belarmina, Belinda, Belmiro, Benedito, Benilde, Bento, Berenice.");
            } else if (index == 1) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> professores: Cácia, Caetano, Caio, Caíque, Caline, Calisto, Caliu, Camargo, Camila, Camilo, Cândido, Cardoso, Carina,Dafne, Dagma, Dagoberto, Dália.");
            } else if (index == 2) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> professores: Dario, Darlene, Débora, Décio, Deise, Denis, Deusdete, Devair, Devilson, Diana.");
            } else if (index == 3) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> professores:Ebert, Edelina, Eder, Edgar, Edilva, Edimar, Edmundo, Edna, Ednalva, Edson, Eduarda, Eduardo.");
            } else if (index == 4) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> professores:Fabiana, Fabiane, Fabiano, Fábio, Fabíola, Fabrício, Fagundes, Farias, Fátima, Fausto, Felícia.");
            } else if (index == 5) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> professores:Gabriel, Gabriela, Gabriele, Galdino, Galileu, Geani, Geciara, Gedeão, Geísa, Geisiane.");
            } else if (index == 6) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> professores:Jaciara, Jade, Jailson, Jair, Jamile, Jane, Janete, Jânio, Jardel, Jasmim, Jean, Jeane, Jénifer, Jeová, Jerônimo, Jerusa, Jéssica, Joana, João, Joaquim, Joaquina, Joel, Joelma, Joice.");
            } else if (index == 7) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> professores: Lacerda, Laércio, Laiane, Laila, Laís, Lana, Lara, Larissa, Laura, Lauriane, Lázaro, Leandro.");
            } else if (index == 8) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> professores:Obdias, Octavio, Odair, Odélia, Odemar, Odemara, Odérico, Oderlan, Oderlei, Oderlene, Odessa,Pablo, Pacheco, Paco, Paiva.");
            } else if (index == 9) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> professores:Rabelo, Rafael, Rafaela, Raiane, Railson, Raimunda, Raimundo, Raissa, Ramires, Ramon, Ramos,Sabino, Sabrina, Sales, Salomão, Salomé, Salvina, Samanta, Samira, Sampaio, Samuel, Sandra.");
            } else if (index == 10) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> professores: Zacarias, Zafira, Zaíra, Zamir, Zamira, Zanato, Zanei, Zânia, Zaqueu, Zaquias, Zeca, Zelda,Xaiane, Xamil, Xamila, Xamilo.");
            }
        });
        f.add(nome);
        nome.setBounds(10, 290, 470, 100);
    }

    public void curso_diciplinas(JFrame f) {
        f.setSize(490, 612);
        f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setLayout(null);
        JLabel cnome = new JLabel("<html><font size=5 color=rgb(0,0,0)> nome do curso:");
        f.add(cnome);
        cnome.setBounds(10, 40, 200, 20);
        String[] list = {"Administração de Empresas", "BioMedicina", "Ciências Biológicas", "Ciencias da Computação", "Direito", "Educação Física", "Farmacologia", "Rede de Computadores", "Sistemas de Informações", "Arquitetura e Urbanismo", "Ciência de Dados"};
        JList lista = new JList(list);
        lista.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        f.add(lista);
        lista.setBounds(10, 80, 400, 200);
        lista.addListSelectionListener(e -> {
            int index = lista.getSelectedIndex();
            if (index == 0) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:Sociologia e Política,Filosofia aplicada à Administração,Psicologia Geral e Aplicad,Direito aplicado à Administração.");
            } else if (index == 1) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:Citologia,Complementos de Matemática I,Química Geral e Inorgânica,Complementos de Matemática II,Histologia II (Anatomia Microscópica).");
            } else if (index == 2) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:BIOLOGIA CELULAR,BIOLOGIA DE CRIPTÓGRAMAS,ANATOMIA HUMANA,FISIOLOGIA HUMANA D,FISIOLOGIA VEGETAL II,ESTÁGIO SUPERVISIONADO II.");
            } else if (index == 3) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:MATEMATICA DISCRETA I,CIENCIA, TECNOLOGIA E SOCIEDADE NA MATEMATICA E NA COMPUTACAO,PROJETO E ANALISE DE ALGORITMOS I,PROJETO E ANALISE DE ALGORITMOS II.");
            } else if (index == 4) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:MODELAGEM MATEMATICA II,PROJETOS INTEGRADORES IV,ENGENHARIA DE SOFTWARE,PRINCIPIOS DE EMPREENDEDORISMO,LINGUAGENS FORMAIS E AUTOMATOS.");
            } else if (index == 5) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:Atividades Práticas Extraclasse,Direito Administrativo - 1,Direito Financeiro e Tributário - 1,Direito Processual Civil - 1.");
            } else if (index == 6) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:ANATOMIA SISTÊMICA,PSICOLOGIA DO DESENVOLVIMENTO E DA APRENDIZAGEM,MEDIDA E AVALIAÇÃO EM EDUCAÇÃO FÍSICA,HISTÓRIA DOS POVOS INDÍGENAS E AFRO-DESCENDENTES.");
            } else if (index == 7) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:Comunicação e Expressão,Desenvolvimento Pessoal e Trabalhabilidade,Organização e Arquitetura de Computadores,Tópicos Integradores I (Redes de Computadores).");
            } else if (index == 8) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:Arquitetura de Computadores,Tópicos Integradores I,MATEMATICA DISCRETA I,CIENCIA, TECNOLOGIA E SOCIEDADE NA MATEMATICA E NA COMPUTACAO,ENGENHARIA DE SOFTWARE.");
            } else if (index == 9) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:Desenho Artístico,Desenho Técnico,Introdução a Gestão de Projetos,Análise e Gestão Ambiental,Projeto e Instalações Prediais,Planejamento Urbano.");
            } else if (index == 10) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:MATEMATICA DISCRETA I,CIENCIA, TECNOLOGIA E SOCIEDADE NA MATEMATICA E NA COMPUTACAO,ENGENHARIA DE SOFTWARE,PRINCIPIOS DE EMPREENDEDORISMO,LINGUAGENS FORMAIS E AUTOMATOS.");
            }
        });
        f.add(nome);
        nome.setBounds(10, 290, 470, 100);
    }

    public void professores_diciplinas(JFrame f) {
        f.setSize(490, 612);
        f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setLayout(null);
        JLabel cnome = new JLabel("<html><font size=5 color=rgb(0,0,0)> nome do professor:");
        f.add(cnome);
        cnome.setBounds(10, 40, 200, 20);
        String[] list = {"Ana Maria", "Simone Buvier", "Antonia Rodrigues", "Marcos Junior", "rafel da Silva", "Rogério santos", "Rodrigo aguiar", "João Pedro de Souza", "Marcos antonio", "Maria simara", "Pedro henrique de Souza"};
        JList lista = new JList(list);
        lista.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        f.add(lista);
        lista.setBounds(10, 80, 400, 200);
        lista.addListSelectionListener(e -> {
            int index = lista.getSelectedIndex();
            if (index == 0) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:Sociologia e Política,Filosofia aplicada à Administração,Psicologia Geral e Aplicad,Direito aplicado à Administração.");
            } else if (index == 1) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:Citologia,Complementos de Matemática I,Química Geral e Inorgânica,Complementos de Matemática II,Histologia II (Anatomia Microscópica).");
            } else if (index == 2) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:BIOLOGIA CELULAR,BIOLOGIA DE CRIPTÓGRAMAS,ANATOMIA HUMANA,FISIOLOGIA HUMANA D,FISIOLOGIA VEGETAL II,ESTÁGIO SUPERVISIONADO II.");
            } else if (index == 3) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:MATEMATICA DISCRETA I,CIENCIA, TECNOLOGIA E SOCIEDADE NA MATEMATICA E NA COMPUTACAO,PROJETO E ANALISE DE ALGORITMOS I,PROJETO E ANALISE DE ALGORITMOS II.");
            } else if (index == 4) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:MODELAGEM MATEMATICA II,PROJETOS INTEGRADORES IV,ENGENHARIA DE SOFTWARE,PRINCIPIOS DE EMPREENDEDORISMO,LINGUAGENS FORMAIS E AUTOMATOS.");
            } else if (index == 5) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:Atividades Práticas Extraclasse,Direito Administrativo - 1,Direito Financeiro e Tributário - 1,Direito Processual Civil - 1.");
            } else if (index == 6) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:ANATOMIA SISTÊMICA,PSICOLOGIA DO DESENVOLVIMENTO E DA APRENDIZAGEM,MEDIDA E AVALIAÇÃO EM EDUCAÇÃO FÍSICA,HISTÓRIA DOS POVOS INDÍGENAS E AFRO-DESCENDENTES.");
            } else if (index == 7) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:Comunicação e Expressão,Desenvolvimento Pessoal e Trabalhabilidade,Organização e Arquitetura de Computadores,Tópicos Integradores I (Redes de Computadores).");
            } else if (index == 8) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:Arquitetura de Computadores,Tópicos Integradores I,MATEMATICA DISCRETA I,CIENCIA, TECNOLOGIA E SOCIEDADE NA MATEMATICA E NA COMPUTACAO,ENGENHARIA DE SOFTWARE.");
            } else if (index == 9) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:Desenho Artístico,Desenho Técnico,Introdução a Gestão de Projetos,Análise e Gestão Ambiental,Projeto e Instalações Prediais,Planejamento Urbano.");
            } else if (index == 10) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:MATEMATICA DISCRETA I,CIENCIA, TECNOLOGIA E SOCIEDADE NA MATEMATICA E NA COMPUTACAO,ENGENHARIA DE SOFTWARE,PRINCIPIOS DE EMPREENDEDORISMO,LINGUAGENS FORMAIS E AUTOMATOS.");
            }
        });
        f.add(nome);
        nome.setBounds(10, 290, 470, 100);
    }

    public void alunos_diciplinas(JFrame f) {
        f.setSize(490, 612);
        f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setLayout(null);
        JLabel cnome = new JLabel("<html><font size=5 color=rgb(0,0,0)> nome dos alunos:");
        f.add(cnome);
        cnome.setBounds(10, 40, 200, 20);
        String[] list = {"thiago martins", "Luan carlos", "stefanie oliveira", "edmilson pereira", "gabriel santos da silva", "rodrigo maia", "dulcimara de angelo", "João Pedro de Souza", "vinnicius de limeira", "Maria simara", "Pedro henrique de Souza"};
        JList lista = new JList(list);
        lista.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        f.add(lista);
        lista.setBounds(10, 80, 400, 200);
        lista.addListSelectionListener(e -> {
            int index = lista.getSelectedIndex();
            if (index == 0) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:Sociologia e Política,Filosofia aplicada à Administração,Psicologia Geral e Aplicad,Direito aplicado à Administração.");
            } else if (index == 1) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:Citologia,Complementos de Matemática I,Química Geral e Inorgânica,Complementos de Matemática II,Histologia II (Anatomia Microscópica).");
            } else if (index == 2) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:BIOLOGIA CELULAR,BIOLOGIA DE CRIPTÓGRAMAS,ANATOMIA HUMANA,FISIOLOGIA HUMANA D,FISIOLOGIA VEGETAL II,ESTÁGIO SUPERVISIONADO II.");
            } else if (index == 3) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:MATEMATICA DISCRETA I,CIENCIA, TECNOLOGIA E SOCIEDADE NA MATEMATICA E NA COMPUTACAO,PROJETO E ANALISE DE ALGORITMOS I,PROJETO E ANALISE DE ALGORITMOS II.");
            } else if (index == 4) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:MODELAGEM MATEMATICA II,PROJETOS INTEGRADORES IV,ENGENHARIA DE SOFTWARE,PRINCIPIOS DE EMPREENDEDORISMO,LINGUAGENS FORMAIS E AUTOMATOS.");
            } else if (index == 5) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:Atividades Práticas Extraclasse,Direito Administrativo - 1,Direito Financeiro e Tributário - 1,Direito Processual Civil - 1.");
            } else if (index == 6) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:ANATOMIA SISTÊMICA,PSICOLOGIA DO DESENVOLVIMENTO E DA APRENDIZAGEM,MEDIDA E AVALIAÇÃO EM EDUCAÇÃO FÍSICA,HISTÓRIA DOS POVOS INDÍGENAS E AFRO-DESCENDENTES.");
            } else if (index == 7) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:Comunicação e Expressão,Desenvolvimento Pessoal e Trabalhabilidade,Organização e Arquitetura de Computadores,Tópicos Integradores I (Redes de Computadores).");
            } else if (index == 8) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:Arquitetura de Computadores,Tópicos Integradores I,MATEMATICA DISCRETA I,CIENCIA, TECNOLOGIA E SOCIEDADE NA MATEMATICA E NA COMPUTACAO,ENGENHARIA DE SOFTWARE.");
            } else if (index == 9) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:Desenho Artístico,Desenho Técnico,Introdução a Gestão de Projetos,Análise e Gestão Ambiental,Projeto e Instalações Prediais,Planejamento Urbano.");
            } else if (index == 10) {
                nome.setText("<html><font size=4 color=rgb(0,0,0)> diciplinas:MATEMATICA DISCRETA I,CIENCIA, TECNOLOGIA E SOCIEDADE NA MATEMATICA E NA COMPUTACAO,ENGENHARIA DE SOFTWARE,PRINCIPIOS DE EMPREENDEDORISMO,LINGUAGENS FORMAIS E AUTOMATOS.");
            }
        });
        f.add(nome);
        nome.setBounds(10, 290, 470, 100);
    }

    public void mcurso(JFrame f) {
        try {
            f.setSize(520, 612);
            f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            f.setResizable(false);
            f.setLayout(null);
            int j = 00;
            resul = new JLabel();
            String aumenta = "<html> <div height=0px width=10px></div>";
            ArrayList<JButton> buttonList = new ArrayList<JButton>();
            Connection con = new escola.ConnectionFactory().getConnection();
            PreparedStatement pesquisab = con.prepareStatement("select * from curso;");
            ResultSet resultado = pesquisab.executeQuery();
            while (resultado.next()) {
                buttonList.add(new JButton("editar"));
                resul.add(buttonList.get(buttonList.size() - 1));
                buttonList.get(buttonList.size() - 1).setBounds(390, j + 12, 100, 20);
                String nomebd = resultado.getString("nomecurso");
                codebd = resultado.getString("cod_curso");
                String tipobd = resultado.getString("tipocurso");
                String cargabd = resultado.getString("cargahoraria");
                String codinstitutobd = resultado.getString("codinstituto");
                resul.add(resulbd = new JLabel("<html><font size=4 color=rgb(0,0,0)>&nbsp código do curso:" + codebd + "<br> &nbsp nome do curso:" + nomebd + " &nbsp &nbsp tipo de curso:" + tipobd + "<br> &nbsp carga horária:" + cargabd + " horas &nbsp &nbsp &nbsp &nbsp código do instituto:" + codinstitutobd));
                resulbd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
                resulbd.setBounds(0, j, 498, 80);
                j += 80;
                String casobt = codebd;
                resul.setText(aumenta);
                aumenta = aumenta + "<div height=71px> </div>";
                buttonList.get(buttonList.size() - 1).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ecurso(casobt);
                    }
                });
            }
            JScrollPane doabarroll = new JScrollPane(resul);
            doabarroll.getVerticalScrollBar().setUnitIncrement(15);
            doabarroll.setBorder(null);
            doabarroll.setBounds(0, 0, 515, 585);
            f.add(doabarroll);
        } catch (SQLException ex) {
            Logger.getLogger(Escola.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Escola.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnexpectedException ex) {
            Logger.getLogger(Escola.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ecurso(String cod) {
        try {
            codf = cod;
            Connection con = new escola.ConnectionFactory().getConnection();
            PreparedStatement pesquisab = con.prepareStatement("select * from curso where cod_curso='" + cod + "';");
            ResultSet resultado = pesquisab.executeQuery();
            while (resultado.next()) {
                String nomebd = resultado.getString("nomecurso");
                String tipobd = resultado.getString("tipocurso");
                String cargabd = resultado.getString("cargahoraria");
                String codinstitutobd = resultado.getString("codinstituto");
                JFrame f = new JFrame("editar cadastro");
                f.setSize(490, 612);
                f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
                f.setResizable(false);
                f.setLayout(null);
                JLabel cod_curso = new JLabel("<html><font size=3 color=rgb(0,0,0)> código do curso:");
                codcurso = new JTextField();
                f.add(cod_curso);
                cod_curso.setBounds(10, 8, 100, 13);
                f.add(jbexcluir);
                jbexcluir.setBounds(375, 8, 100, 20);
                f.add(codcurso);
                codcurso.setToolTipText("código do curso");
                codcurso.setBounds(120, 6, 106, 20);
                codcurso.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
                JLabel cnome = new JLabel("<html><font size=5 color=rgb(0,0,0)> nome do curso:");
                f.add(cnome);
                cnome.setBounds(10, 40, 200, 20);
                String[] list = {"Administração de Empresas", "BioMedicina", "Ciências Biológicas", "Ciencias da Computação", "Direito", "Educação Física", "Farmacologia", "Rede de Computadores", "Sistemas de Informações", "Arquitetura e Urbanismo", "Ciência de Dados"};
                JList lista = new JList(list);
                lista.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
                f.add(lista);
                lista.setBounds(10, 80, 400, 200);
                nome_curso = "";
                tipo_cur = "";
                for (int i = 0; i < list.length; i++) {
                    if (nomebd.equals(list[i])) {
                        lista.setSelectedIndex(i);
                    }
                }
                lista.addListSelectionListener(e -> {
                    int index = lista.getSelectedIndex();
                    if (index == 0) {
                        nome_curso = list[0];
                    } else if (index == 1) {
                        nome_curso = list[1];
                    } else if (index == 2) {
                        nome_curso = list[2];
                    } else if (index == 3) {
                        nome_curso = list[3];
                    } else if (index == 4) {
                        nome_curso = list[4];
                    } else if (index == 5) {
                        nome_curso = list[5];
                    } else if (index == 6) {
                        nome_curso = list[6];
                    } else if (index == 7) {
                        nome_curso = list[7];
                    } else if (index == 8) {
                        nome_curso = list[8];
                    } else if (index == 9) {
                        nome_curso = list[9];
                    } else if (index == 10) {
                        nome_curso = list[10];
                    }
                });
                JLabel tipo_curso = new JLabel("<html><font size=5 color=rgb(0,0,0)>tipo de curso:");
                f.add(tipo_curso);
                tipo_curso.setBounds(10, 295, 150, 20);
                f.add(bacharel);
                f.add(gestao);
                f.add(outros);
                bacharel.setBounds(10, 320, 100, 20);
                gestao.setBounds(10, 350, 100, 20);
                outros.setBounds(10, 380, 100, 20);
                bacharel.addActionListener(this);
                jbexcluir.addActionListener(this);
                gestao.addActionListener(this);
                outros.addActionListener(this);
                JLabel codigo_intituto = new JLabel("<html><font size=5 color=rgb(0,0,0)> código instituto:");
                ccodigo = new JTextField();
                f.add(codigo_intituto);
                codigo_intituto.setBounds(10, 410, 160, 22);
                f.add(ccodigo);
                ccodigo.setToolTipText(" código instituto");
                ccodigo.setBounds(10, 440, 106, 20);
                ccodigo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
                JLabel carga_horaria = new JLabel("<html><font size=5 color=rgb(0,0,0)> carga horária:");
                f.add(carga_horaria);
                carga_horaria.setBounds(10, 465, 200, 23);
                jbeditar = new JButton();
                f.add(jbeditar);
                jbeditar.setBounds(334, 535, 150, 50);
                jbeditar.setBackground(new Color(138, 43, 226));
                JLabel jlbar = new JLabel("<html><font size=5 color=rgb(0,0,0)>");
                jlbar.setBackground(new Color(138, 43, 226));
                jlbar.setOpaque(true);
                f.add(jlbar);
                JLabel jlcadastrar = new JLabel("<html><font size=5 color=rgb(0,0,0)>&nbsp &nbsp &nbsp &nbsp &nbsp editar");
                jbeditar.add(jlcadastrar);
                jbeditar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 2, true));
                jlbar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 0, 130), 2, true));
                jlbar.setBounds(0, 535, 334, 50);
                jbeditar.addActionListener(this);
                codcurso.setText(cod);
                bacharel.setSelected(false);
                outros.setSelected(false);
                gestao.setSelected(false);
                if (tipobd.equals("Bacharel")) {
                    bacharel.setSelected(true);
                } else if (tipobd.equals("outros")) {
                    outros.setSelected(true);
                } else if (tipobd.equals("Gestão")) {
                    gestao.setSelected(true);
                }
                carga_hora = new JSpinner(new SpinnerNumberModel(Integer.parseInt(cargabd), 1, null, 1));
                f.add(carga_hora);
                carga_hora.setToolTipText("carga horária");
                carga_hora.setBounds(10, 490, 80, 20);
                carga_hora.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
                ccodigo.setText(codinstitutobd);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Escola.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Escola.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnexpectedException ex) {
            Logger.getLogger(Escola.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
        } else if (e.getSource() == ccurso) {
            JFrame f = new JFrame("cadastro curso");
            jlcadastrar.setText("<html><font size=5 color=rgb(0,0,0)>&nbsp &nbsp &nbsp cadastrar");
            ccurso(f);

        } else if (e.getSource() == cdiciplina) {
            JFrame f = new JFrame("cadastro de diciplina");
            jlcadastrar.setText("<html><font size=5 color=rgb(0,0,0)>&nbsp &nbsp &nbsp cadastrar");
            cdiciplina(f);

        } else if (e.getSource() == caluno) {
            JFrame f = new JFrame("cadastro aluno");
            jlcadastrar.setText("<html><font size=5 color=rgb(0,0,0)>&nbsp &nbsp &nbsp cadastrar");
            cdaluno(f);

        } else if (e.getSource() == cprofessor) {
            JFrame f = new JFrame("cadastro professor");
            jlcadastrar.setText("<html><font size=5 color=rgb(0,0,0)>&nbsp &nbsp &nbsp cadastrar");
            cprof(f);

        } else if (e.getSource() == mprofessor) {
            JFrame f = new JFrame("mostrar professor");
            jlcadastrar.setText("<html><font size=5 color=rgb(0,0,0)>&nbsp &nbsp &nbsp mostrar");
            cprof(f);

        } else if (e.getSource() == maluno) {
            JFrame f = new JFrame("mostrar professor");
            jlcadastrar.setText("<html><font size=5 color=rgb(0,0,0)>&nbsp &nbsp &nbsp mostrar");
            cdaluno(f);

        } else if (e.getSource() == mdiciplina) {
            jlcadastrar.setText("<html><font size=5 color=rgb(0,0,0)>&nbsp &nbsp &nbsp mostrar");
            JFrame f = new JFrame("mostrar diciplina");
            cdiciplina(f);

        } else if (e.getSource() == mcurso_professores) {
            JFrame f = new JFrame("mostrar curso/professores");
            curso_prof(f);

        } else if (e.getSource() == mcurso_diciplinas) {
            JFrame f = new JFrame("mostrar curso/diciplinas");
            curso_diciplinas(f);

        } else if (e.getSource() == mprofessores_diciplinas) {
            JFrame f = new JFrame("mostrar professores/diciplinas");
            professores_diciplinas(f);

        } else if (e.getSource() == malunos_diciplinas) {
            JFrame f = new JFrame("mostrar alunos/diciplinas");
            alunos_diciplinas(f);

        } else if (e.getSource() == mcurso) {
            JFrame f = new JFrame("mostrar curso");
            mcurso(f);

        } else if (rdbtn_1.isSelected() == true && e.getSource() == rdbtn_1) {
            rdbtn_2.setSelected(false);
            rdbtn_3.setSelected(false);
            rdbtn_4.setSelected(false);
            rdbtn_5.setSelected(false);
            rdbtn_6.setSelected(false);
        } else if (rdbtn_2.isSelected() == true && e.getSource() == rdbtn_2) {
            rdbtn_1.setSelected(false);
            rdbtn_3.setSelected(false);
            rdbtn_4.setSelected(false);
            rdbtn_5.setSelected(false);
            rdbtn_6.setSelected(false);
        } else if (rdbtn_3.isSelected() == true && e.getSource() == rdbtn_3) {
            rdbtn_1.setSelected(false);
            rdbtn_2.setSelected(false);
            rdbtn_4.setSelected(false);
            rdbtn_5.setSelected(false);
            rdbtn_6.setSelected(false);
        } else if (rdbtn_4.isSelected() == true && e.getSource() == rdbtn_4) {
            rdbtn_1.setSelected(false);
            rdbtn_2.setSelected(false);
            rdbtn_3.setSelected(false);
            rdbtn_5.setSelected(false);
            rdbtn_6.setSelected(false);
        } else if (rdbtn_5.isSelected() == true && e.getSource() == rdbtn_5) {
            rdbtn_1.setSelected(false);
            rdbtn_2.setSelected(false);
            rdbtn_3.setSelected(false);
            rdbtn_4.setSelected(false);
            rdbtn_6.setSelected(false);
        } else if (rdbtn_6.isSelected() == true && e.getSource() == rdbtn_6) {
            rdbtn_1.setSelected(false);
            rdbtn_2.setSelected(false);
            rdbtn_3.setSelected(false);
            rdbtn_4.setSelected(false);
            rdbtn_5.setSelected(false);
        } else if (bacharel.isSelected() == true && e.getSource() == bacharel) {
            gestao.setSelected(false);
            outros.setSelected(false);
            tipo_cur = "Bacharel";
        } else if (gestao.isSelected() == true && e.getSource() == gestao) {
            bacharel.setSelected(false);
            outros.setSelected(false);
            tipo_cur = "Gestão";
        } else if (outros.isSelected() == true && e.getSource() == outros) {
            bacharel.setSelected(false);
            gestao.setSelected(false);
            tipo_cur = "outros";
        }
        if (e.getSource() == jbcadastrar) {
            String cod = codcurso.getText().trim().toString();
            String instituto = ccodigo.getText().trim().toString();
            if (nome_curso.equals("") == false && cod.equals("") == false && instituto.equals("") == false && tipo_cur.equals("") == false) {
                try {
                    Connection con = new escola.ConnectionFactory().getConnection();
                    PreparedStatement pesquisa = con.prepareStatement("insert into curso values('" + cod + "','" + nome_curso + "','" + tipo_cur + "'," + Integer.parseInt(carga_hora.getValue().toString()) + ",'" + instituto + "');");
                    pesquisa.executeUpdate();
                    System.out.println("cadastrado com sucesso");
                } catch (SQLException ex) {
                    Logger.getLogger(Escola.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Escola.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnexpectedException ex) {
                    Logger.getLogger(Escola.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        if (e.getSource() == jbeditar) {
            String cod = codcurso.getText().trim().toString();
            String instituto = ccodigo.getText().trim().toString();
            if (nome_curso.equals("") == false && cod.equals("") == false && instituto.equals("") == false && tipo_cur.equals("") == false) {
                try {
                    Connection con = new escola.ConnectionFactory().getConnection();
                    PreparedStatement pesquisa = con.prepareStatement("update curso set cod_curso='" + cod + "',nomecurso='" + nome_curso + "', tipocurso='" + tipo_cur + "',cargahoraria=" + Integer.parseInt(carga_hora.getValue().toString()) + ",codinstituto='" + instituto + "' where cod_curso='" + codf + "';");
                    pesquisa.executeUpdate();
                    System.out.println("editado com sucesso");
                } catch (SQLException ex) {
                    Logger.getLogger(Escola.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Escola.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnexpectedException ex) {
                    Logger.getLogger(Escola.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (e.getSource() == jbexcluir) {
            try {
                Connection con = new escola.ConnectionFactory().getConnection();
                PreparedStatement pesquisa = con.prepareStatement(" delete from curso where cod_curso='" + codf + "';");
                pesquisa.executeUpdate();
                System.out.println("excluido com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(Escola.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Escola.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnexpectedException ex) {
                Logger.getLogger(Escola.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
