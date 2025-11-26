-- PROFESSORES
INSERT INTO professor (nome, login) VALUES ('Carlos Alberto', 'carlos.prof');
INSERT INTO professor (nome, login) VALUES ('Ana Paula', 'ana.prof');

-- TURMAS
INSERT INTO turma (nome, professor_id) VALUES ('1º Ano A', 1);
INSERT INTO turma (nome, professor_id) VALUES ('1º Ano B', 2);

-- PLANOS DE SAÚDE
INSERT INTO plano_saude (nome, numero_carteira) VALUES ('Unimed', '123456');
INSERT INTO plano_saude (nome, numero_carteira) VALUES ('Bradesco Saúde', '998877');

-- ALUNOS
INSERT INTO aluno (nome, matricula, marcador_visual, turma_id, plano_de_saude_id) VALUES ('Mariana Santos', 'A001', TRUE, 1, 1);
INSERT INTO aluno (nome, matricula, marcador_visual, turma_id, plano_de_saude_id) VALUES ('Pedro Silva', 'A002', FALSE, 1, 2);
INSERT INTO aluno (nome, matricula, marcador_visual, turma_id, plano_de_saude_id) VALUES ('Lucas Rocha', 'A003', TRUE, 2, 1);

-- RESPONSÁVEIS
INSERT INTO responsavel (nome, telefone, relacao) VALUES ('Maria Santos', '11988887777', 'Mãe');
INSERT INTO responsavel (nome, telefone, relacao) VALUES ('Ricardo Silva', '11999996666', 'Pai');

-- CONDIÇÕES MÉDICAS
INSERT INTO condicao_medica (descricao, aluno_id) VALUES ('Alergia a amendoim', 1);
INSERT INTO condicao_medica (descricao, aluno_id) VALUES ('Asma', 3);

-- ENFERMARIA
INSERT INTO enfermaria (nome, login) VALUES ('Enfermeira Júlia', 'julia.enf');

-- PORTARIA
INSERT INTO portaria (nome, login) VALUES ('Roberto da Portaria', 'roberto.port');

-- EMERGÊNCIAS
INSERT INTO emergencia (data_hora, status, descricao, aluno_id) VALUES ('2025-01-10T10:30:00', 'ABERTA', 'Crise de asma', 3);
INSERT INTO emergencia (data_hora, status, descricao, aluno_id) VALUES ('2025-01-11T14:20:00', 'ABERTA', 'Queda no pátio', 1);

-- ATENDIMENTO
INSERT INTO atendimento (decisao, observacoes, emergencia_id) VALUES ('SAMU', 'Aluno em crise forte, encaminhado', 1);

-- NOTIFICAÇÕES
INSERT INTO notificacao (tipo, mensagem, data_hora, emergencia_id) VALUES ('ENFERMARIA', 'Aluno em emergência, verificar imediatamente.', '2025-01-10T10:31:00', 1);
INSERT INTO notificacao (tipo, mensagem, data_hora, emergencia_id) VALUES ('RESPONSAVEIS', 'Seu filho sofreu uma queda.', '2025-01-11T14:21:00', 2);

-- LOG DE AÇÃO
INSERT INTO log_de_acao (usuario, acao, data_hora) VALUES ('Sistema', 'Criou emergência ID=1', '2025-01-10T10:30:05');
INSERT INTO log_de_acao (usuario, acao, data_hora) VALUES ('Sistema', 'Criou emergência ID=2', '2025-01-11T14:20:05');
INSERT INTO log_de_acao (usuario, acao, data_hora) VALUES ('Enfermaria', 'Registrou atendimento da emergência 1', '2025-01-10T10:32:00');
