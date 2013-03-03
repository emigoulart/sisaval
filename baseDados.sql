DROP TABLE IF EXISTS aluno;
CREATE TABLE aluno (
  alu_mat integer not null,
  alu_nome varchar(40) NOT NULL,
  alu_dtanasc date,
  alu_endereco varchar(50),
  alu_telefone varchar(20),
  alu_email varchar(100) NOT NULL,
  alu_login varchar(20) NOT NULL,
  alu_senha varchar(20) NOT NULL,
  alu_tipo char(1) NOT NULL, -- A: Administrador, U: Usuario
  fk_alu_cur integer,
  CONSTRAINT pk_aluno_matricula PRIMARY KEY (alu_mat)
  
);


DROP TABLE IF EXISTS administrador;
CREATE TABLE administrador (
  adm_ID serial,
  adm_nome varchar(40) NOT NULL,
  adm_dtanasc date,
  adm_endereco varchar(50),
  adm_telefone varchar(20),
  adm_email varchar(100) NOT NULL,
  adm_login varchar(20) NOT NULL,
  adm_senha varchar(20) NOT NULL,
  adm_tipo char(1) NOT NULL, -- A: Administrador, U: Usuario, P: Professor
  CONSTRAINT pk_admin_ID PRIMARY KEY (adm_ID)
);


DROP TABLE IF EXISTS professor;
CREATE TABLE professor (
  prf_ID serial,
  prf_nome varchar(40) NOT NULL,
  prf_dtanasc date,
  prf_endereco varchar(50),
  prf_telefone varchar(20),
  prf_email varchar(100) NOT NULL,
  prf_login varchar(20) NOT NULL,
  prf_senha varchar(20) NOT NULL,
  prf_tipo char(1) NOT NULL, -- A: Administrador, U: Usuario
  CONSTRAINT pk_profID PRIMARY KEY (prf_ID)
);

DROP TABLE IF EXISTS curso;
CREATE TABLE curso (
cur_ID serial,
cur_nome varchar(50) NOT NULL,
cur_tipo varchar(20) NOT NULL,
cur_descricao text NOT NULL,
CONSTRAINT pk_id_curso PRIMARY KEY (cur_ID)
);

DROP TABLE IF EXISTS disciplina;
CREATE TABLE disciplina (
  dis_ID serial,
  dis_nome varchar(50) NOT NULL,
  dis_descricao text NOT NULL,
  fk_professor integer NOT NULL,
  CONSTRAINT pk_id_disciplina PRIMARY KEY (dis_ID),
  CONSTRAINT fk_professorID FOREIGN KEY(fk_professor) REFERENCES professor(prf_ID)
);
DROP TABLE IF EXISTS cursodisciplina;
CREATE TABLE cursodisciplina (
   fk_Curso integer NOT NULL,
   fk_Disciplina integer NOT NULL,
   CONSTRAINT fk_cursoID FOREIGN KEY(fk_curso) REFERENCES curso(cur_ID),
   CONSTRAINT fk_disciplinaID FOREIGN KEY(fk_Disciplina) REFERENCES disciplina(dis_ID)
);

--relaciona mento aluno disciplina (aluno<->diciplina) fkdiscuplina fkaluno fkprofessor
DROP TABLE IF EXISTS alunodisciplina;
CREATE TABLE alunodisciplina(
  fk_aluno integer not null,
  fk_disciplina integer not null,
  CONSTRAINT FK_aluno FOREIGN KEY(fk_aluno) REFERENCES aluno(alu_mat),
  CONSTRAINT FK_disciplina FOREIGN KEY(fk_disciplina) REFERENCES disciplina(dis_ID)
);

DROP TABLE IF EXISTS alternativa;
CREATE TABLE alternativa(
  alt_ID serial,
  alt_alternativa Text,
  CONSTRAINT FK_ALTERNATIVA_ID PRIMARY KEY (alt_ID)
);

DROP TABLE IF EXISTS questao;
CREATE TABLE questao (
  qst_ID serial,
  qst_questao Text,
  fk_alternativa integer,
  CONSTRAINT PK_QUESTAO PRIMARY KEY (qst_ID),
  CONSTRAINT FK_ALTERNATIVA FOREIGN KEY(fk_alternativa) REFERENCES alternativa(alt_ID)
);

DROP TABLE IF EXISTS formulario;
CREATE TABLE formulario (
  frm_ID serial,
  frm_nome varchar(50) NOT NULL,
  fk_questao integer,
  CONSTRAINT PK_FORMULARIO PRIMARY KEY (frm_ID),
  CONSTRAINT FK_QUESTAO FOREIGN KEY(fk_questao) REFERENCES questao(qst_ID)
);

DROP TABLE IF EXISTS avaliacao;
CREATE TABLE avaliacao (
  avl_ID serial,
  avl_disponivel char(1),
  avl_exportada char(1),
  avl_fechada char(1),
  avl_dataInicio date,
  avl_dataFim date,
  fk_alunoDisciplina integer,
  fk_formulario integer,
  CONSTRAINT PK_AVALIACAO_ID PRIMARY KEY (avl_ID),
 -- CONSTRAINT FK_ALUNO FOREIGN KEY(fk_alunoDisciplina) REFERENCES alunodisciplina(qst_ID),
  CONSTRAINT FK_FORMULARIO FOREIGN KEY(fk_formulario) REFERENCES formulario(frm_ID)  
);


 
