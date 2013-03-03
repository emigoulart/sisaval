/* =============== Aluno ======================*/
DROP TABLE IF EXISTS aluno;
CREATE TABLE aluno (
  alu_mat varchar(12),
  alu_nome varchar(40) NOT NULL,
  alu_dtanasc date,
  alu_endereco varchar(50),
  alu_telefone varchar(20),
  alu_email varchar(100) NOT NULL,
  alu_login varchar(20) NOT NULL,
  alu_senha varchar(20) NOT NULL,
  alu_tipo char(1) NOT NULL, -- A: Administrador, U: Usuario 
  fk_alu_cur integer,
  CONSTRAINT pk_aluno_matricula PRIMARY KEY (alu_mat),
  CONSTRAINT fk_aluno_curso FOREIGN KEY (fk_aluno_pes) REFERENCES pessoa(cur_ID)
);

================ Administrador ======================
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


================ Professor ======================
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
  CONSTRAINT pk_profID PRIMARY KEY (prf_ID),
);

================ Curso ===========================
DROP TABLE IF EXISTS curso;
CREATE TABLE curso (
cur_ID serial,
cur_nome varchar(50) NOT NULL,
cur_tipo varchar(20) NOT NULL,
cur_descricao text NOT NULL,
CONSTRAINT pk_id_curso PRIMARY KEY (cur_ID)
);

================ Disciplia ======================
DROP TABLE IF EXISTS disciplina;
CREATE TABLE disciplina (
  dis_ID serial,
  dis_nome varchar(50) NOT NULL,
  dis_descricao text NOT NULL,
  fk_professor integer NOT NULL,
  CONSTRAINT pk_id_disciplina PRIMARY KEY (dis_ID),
  CONSTRAINT fk_professorID FOREIGN KEY(fk_professor) REFERENCES professor(prf_ID)
);

================ CursoDisciplina ===========================
DROP TABLE IF EXISTS cursodisciplina;
CREATE TABLE cursodisciplina (
   fk_Curso integer NOT NULL,
   fk_Disciplina integer NOT NULL,
   CONSTRAINT fk_cursoID FOREIGN KEY(fk_curso) REFERENCES curso(cur_ID),
   CONSTRAINT fk_disciplinaID FOREIGN KEY(fk_Disciplina) REFERENCES disciplina(dis_ID)
);

==================== ALUNODISCIPLINA ===============================
--relaciona mento aluno disciplina (aluno<->diciplina) fkdiscuplina fkaluno fkprofessor
DROP TABLE IF EXISTS alunodisciplina 
CREATE TABLE alunodisciplina(
  fk_aluno integer not null,
  fk_disciplina integer not null,
  CONSTRAINT FK_aluno FOREIGN KEY(fk_aluno) REFERENCES aluno(alu_mat),
  CONSTRAINT FK_disciplina FOREIGN KEY(fk_disciplina) REFERENCES disciplina(dis_ID)
);

================ Avaliacao ===========================
DROP TABLE IF EXISTS avaliacao;
CREATE TABLE avaliacao (
  avl_ID serial,
  avl_disponivel char(1),
  avl_exportada char(1),
  avl_fechada char(1),
  avl_dataInicio date,
  avl_dataFim date
  fk_alunoDisciplina
  fk_formulario integer,
  CONTSTRIANT PK_AVALIACAO_ID PRIMARY KEY (avl_ID),
  CONSTRAINT FK_ALUNO FOREIGN KEY(fk_alunoDisciplina) REFERENCES alunodisciplina(qst_ID)  
  CONSTRAINT FK_FORMULARIO FOREIGN KEY(fk_formulario) REFERENCES formulario(frm_ID)	
);

================ Formulário ===========================
DROP TABLE IF EXISTS formulario;
CREATE TABLE formulario (
  frm_ID serial,
  frm_nome varchar(50) NOT NULL,
  fk_questao integer,
  CONSTRAINT FK_QUESTAO_ID PRIMARY KEY (frm_ID),
  CONSTRAINT FK_QUESTAO FOREIGN KEY(fk_questao) REFERENCES questao(qst_ID)
);

================ Questões ===========================
DROP TABLE IF EXISTS questao;
CREATE TABLE questao (
  qst_ID serial,
  qst_questao Text,
  fk_alternativa integer,
  CONSTRAINT FK_QUESTAO_ID PRIMARY KEY (qst_ID),
  CONSTRAINT FK_ALTERNATIVA FOREIGN KEY(fk_alternatica) REFERENCES alternativa(qst_ID)
);

================ Alternativas ===========================
DROP TABLE IF EXISTS alternativa;
CREATE TABLE alterantiva(
  alt_ID serial,
  alt_alternativa Text,
  CONSTRAINT FK_ALTERNATIVA_ID PRIMARY KEY (alt_ID)
); 

