INSERT INTO professor (nome, login) VALUES ('Osvaldo', 'osvaldo.prof');
INSERT INTO professor (nome, login) VALUES ('Luan', 'luan.prof');

INSERT INTO turma (nome, professor_id) VALUES ('ADS T1', 1);
INSERT INTO turma (nome, professor_id) VALUES ('ADS T2', 2);

INSERT INTO plano_saude (nome, numero_carteira) VALUES ('Unimed', '123456');
INSERT INTO plano_saude (nome, numero_carteira) VALUES ('Hapvida', '998877');

INSERT INTO aluno (nome, matricula, marcador_visual, turma_id, plano_de_saude_id) VALUES ('Mariana Santos', 'A001', TRUE, 1, 1);
INSERT INTO aluno (nome, matricula, marcador_visual, turma_id, plano_de_saude_id) VALUES ('Pedro Silva', 'A002', FALSE, 1, 2);
INSERT INTO aluno (nome, matricula, marcador_visual, turma_id, plano_de_saude_id) VALUES ('Lucas Rocha', 'A003', TRUE, 2, 1);

INSERT INTO responsavel (nome, telefone, relacao) VALUES ('Maria Santos', '11988887777', 'Mãe');
INSERT INTO responsavel (nome, telefone, relacao) VALUES ('Ricardo Silva', '11999996666', 'Pai');

INSERT INTO condicao_medica (descricao, aluno_id) VALUES ('Alergia a amendoim', 1);
INSERT INTO condicao_medica (descricao, aluno_id) VALUES ('Asma', 3);

INSERT INTO enfermaria (nome, login) VALUES ('Enfermeira Júlia', 'julia.enf');

INSERT INTO portaria (nome, login) VALUES ('Roberto da Portaria', 'roberto.port');
