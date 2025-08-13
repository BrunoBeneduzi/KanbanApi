-- Inserir usuário ADM
INSERT INTO usuario (id, email, senha, role)
VALUES (1, 'adm@email.com', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.', 'ADM')
ON CONFLICT (id) DO NOTHING;

-- Inserir usuários colaboradores
INSERT INTO usuario (id, email, senha, role)
VALUES 
(2, 'colab1@email.com', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.', 'COLABORADOR'),
(3, 'colab2@email.com', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.', 'COLABORADOR'),
(4, 'colab3@email.com', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.', 'COLABORADOR'),
(5, 'colab4@email.com', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.', 'COLABORADOR'),
(6, 'colab5@email.com', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.', 'COLABORADOR')
ON CONFLICT (id) DO NOTHING;

-- Inserir tarefas (2 para cada colaborador)
INSERT INTO task (id, titulo, descricao, responsavel, data_de_entrega, status, usuario_id)
VALUES
(1, 'Tarefa 1', 'Descrição da tarefa 1', 'colab1@email.com', CURRENT_DATE + INTERVAL '1 day', 'PENDENTE', 2),
(2, 'Tarefa 2', 'Descrição da tarefa 2', 'colab1@email.com', CURRENT_DATE + INTERVAL '2 day', 'PENDENTE', 2),
(3, 'Tarefa 3', 'Descrição da tarefa 3', 'colab2@email.com', CURRENT_DATE + INTERVAL '1 day', 'PENDENTE', 3),
(4, 'Tarefa 4', 'Descrição da tarefa 4', 'colab2@email.com', CURRENT_DATE + INTERVAL '2 day', 'PENDENTE', 3),
(5, 'Tarefa 5', 'Descrição da tarefa 5', 'colab3@email.com', CURRENT_DATE + INTERVAL '1 day', 'PENDENTE', 4),
(6, 'Tarefa 6', 'Descrição da tarefa 6', 'colab3@email.com', CURRENT_DATE + INTERVAL '2 day', 'PENDENTE', 4),
(7, 'Tarefa 7', 'Descrição da tarefa 7', 'colab4@email.com', CURRENT_DATE + INTERVAL '1 day', 'PENDENTE', 5),
(8, 'Tarefa 8', 'Descrição da tarefa 8', 'colab4@email.com', CURRENT_DATE + INTERVAL '2 day', 'PENDENTE', 5),
(9, 'Tarefa 9', 'Descrição da tarefa 9', 'colab5@email.com', CURRENT_DATE + INTERVAL '1 day', 'PENDENTE', 6),
(10, 'Tarefa 10', 'Descrição da tarefa 10', 'colab5@email.com', CURRENT_DATE + INTERVAL '2 day', 'PENDENTE', 6)
ON CONFLICT (id) DO NOTHING;
