
/*CREATE DATABASE "dbAvaliacao"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
     LC_CTYPE = 'Portuguese_Brazil.1252'
      CONNECTION LIMIT = -1;*/
-- Table: usuario
 
DROP TABLE IF EXISTS usuario cascade;

CREATE TABLE usuario
(
  matricula serial NOT NULL,
  nome character varying(40) NOT NULL,
  dtanasc date,
  endereco character varying(50),
  telefone character varying(20),
  email character varying(100) NOT NULL,
  login character varying(20) NOT NULL,
  senha character varying(20) NOT NULL,
  tipo_usuario character(1) NOT NULL,--1 Administrador, 2 Aluno, 3 Professor
  CONSTRAINT pk_usuario_id PRIMARY KEY (matricula)
);




DROP TABLE IF EXISTS curso cascade;
CREATE TABLE curso (
cur_ID serial,
cur_nome varchar(50) NOT NULL,
cur_tipo varchar(20) NOT NULL,
cur_descricao text NOT NULL,
CONSTRAINT pk_curso PRIMARY KEY (cur_ID)
);



DROP TABLE IF EXISTS disciplina cascade;
CREATE TABLE disciplina (
  dis_ID serial,
  dis_nome varchar(50) NOT NULL,
  dis_descricao text NOT NULL,
  CONSTRAINT pk_disciplina PRIMARY KEY (dis_ID)
);

DROP TABLE IF EXISTS alternativa cascade;
CREATE TABLE alternativa(
  alt_ID serial,
  alt_alternativa Text NOT NULL,
  CONSTRAINT pk_alternativa PRIMARY KEY (alt_ID)
);

DROP TABLE IF EXISTS questao cascade;
CREATE TABLE questao (
  qst_ID serial,
  qst_questao Text NOT NULL,
  CONSTRAINT pk_questao PRIMARY KEY (qst_ID)
);

DROP TABLE IF EXISTS questaoalternativas cascade;
CREATE TABLE questaoalternativas (
  fk_questao integer NOT NULL,
  fk_alternativa integer NOT NULL,
  CONSTRAINT pk_questaoalternativa PRIMARY KEY (fk_questao, fk_alternativa),
  CONSTRAINT fk_questaoID FOREIGN KEY(fk_questao) REFERENCES questao(qst_ID),
  CONSTRAINT fk_alternativaID FOREIGN KEY(fk_alternativa) REFERENCES alternativa(alt_ID)
);

DROP TABLE IF EXISTS formulario cascade;
CREATE TABLE formulario (
  frm_ID serial,
  frm_nome varchar(50) NOT NULL,
  observacao text,
  CONSTRAINT pk_formulario PRIMARY KEY (frm_ID)
);

DROP TABLE IF EXISTS formularioquestoes cascade;
CREATE TABLE formularioquestoes (
  fk_formulario integer,
  fk_questao integer,
  CONSTRAINT pk_formularioquestoes PRIMARY KEY (fk_formulario, fk_questao),
  CONSTRAINT fk_formularioID FOREIGN KEY(fk_formulario) REFERENCES formulario(frm_ID),
  CONSTRAINT fk_frmquestoesID FOREIGN KEY(fk_questao) REFERENCES questao(qst_ID)
);

--cursodisciplina
DROP TABLE IF EXISTS turma cascade;
CREATE TABLE turma (
   tur_ID serial,  
   fk_curso integer NOT NULL,
   fk_disciplina integer NOT NULL,
   fk_professor integer NOT NULL,
   fk_formulario integer NOT NULL,
   prazoinicial date not null,
   prazofinal date not null,
   CONSTRAINT pk_turma PRIMARY KEY (tur_id),
   CONSTRAINT fk_cursoturma FOREIGN KEY(fk_curso) REFERENCES curso(cur_ID),
   CONSTRAINT fk_disciplinaturma FOREIGN KEY(fk_disciplina) REFERENCES disciplina(dis_ID),
   CONSTRAINT fk_professorturma FOREIGN KEY(fk_professor) REFERENCES usuario(matricula),
   CONSTRAINT fk_formularioturma FOREIGN KEY(fk_formulario) REFERENCES formulario(frm_ID)
);

--relacionamento aluno disciplina (aluno<->diciplina) fkdiscuplina fkaluno fkprofessor
-- Chamar De TURMA
DROP TABLE IF EXISTS turmaalunos cascade; 
CREATE TABLE turmaalunos(
  fk_turma integer not null,
  fk_aluno integer not null,
  CONSTRAINT pk_turmaalunos PRIMARY KEY (fk_turma, fk_aluno),
  CONSTRAINT fk_turmaID FOREIGN KEY(fk_turma) REFERENCES turma(tur_ID),
  CONSTRAINT fk_alunoturmaAluno FOREIGN KEY(fk_aluno) REFERENCES usuario(matricula)
);


DROP TABLE IF EXISTS avaliacao cascade;
CREATE TABLE avaliacao (
  avl_ID serial,
  avl_disponivel char(1),
  avl_exportada char(1),
  avl_fechada char(1),
  avl_dataInicio date,
  avl_dataFim date,
  fk_turma integer,
  fk_aluno integer,
  fk_formulario integer,
  observacao text,
  CONSTRAINT pk_avaliacaoID PRIMARY KEY (avl_ID),
  CONSTRAINT fk_avaliacaoTurma FOREIGN KEY(fk_turma,fk_aluno) REFERENCES turmaalunos(fk_turma, fk_aluno),
  --CONSTRAINT fk_avaliacaoAluno FOREIGN KEY(fk_aluno) REFERENCES turmaalunos(fk_aluno),
  CONSTRAINT fk_formularioTurma FOREIGN KEY(fk_formulario) REFERENCES formulario(frm_ID)    
);

DROP TABLE IF EXISTS avaliacaorespostas cascade;
CREATE TABLE avaliacaorespostas (
  fk_avaliacao integer not null,
  fk_questao integer not null,
  resposta integer,
  CONSTRAINT pk_avaliacaorespostas PRIMARY KEY (fk_avaliacao, fk_questao),
  CONSTRAINT fk_avaliacaoID FOREIGN KEY(fk_avaliacao) REFERENCES avaliacao(avl_ID),
  CONSTRAINT fk_avalrespostaalt FOREIGN KEY(fk_questao, resposta) REFERENCES questaoalternativas(fk_questao, fk_alternativa)
  );
