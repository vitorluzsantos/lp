package school.sptech;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class Secretaria {

    public List<Aluno> importarAlunos(String caminho) {
        try (InputStream inputStream = new FileInputStream(caminho)) {
            return importarAlunos(inputStream);
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo");
            return new ArrayList<>();
        }
    }

    public List<Aluno> importarAlunos(InputStream entrada) {
        List<Aluno> alunos = new ArrayList<>();
        if (entrada == null) {
            return alunos;
        }

        try {
            InputStreamReader inputStreamReader =
                    new InputStreamReader(entrada, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String linha;
            reader.readLine();
            while ((linha = reader.readLine()) != null) {
                if (linha.isBlank()) {
                    continue;
                }

                String[] colunas = linha.split(";", -1);
                if (colunas.length != 5) {
                    continue;
                }

                try {
                    String ra = colunas[0].trim();
                    String nome = colunas[1].trim();
                    Double nota1 = Double.valueOf(colunas[2].trim());
                    Double nota2 = Double.valueOf(colunas[3].trim());
                    Integer frequencia = Integer.valueOf(colunas[4].trim());

                    alunos.add(new Aluno(ra, nome, nota1, nota2, frequencia));
                } catch (NumberFormatException e) {
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo");
        }
        return alunos;
    }

    public void exportarAlunos(List<Aluno> alunos, String caminho) {
        try (
                FileOutputStream outputStream = new FileOutputStream(caminho, false);
                OutputStreamWriter streamWriter =
                        new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
                BufferedWriter bufferedWriter = new BufferedWriter(streamWriter)
        ) {
            bufferedWriter.write("ra;nome;nota1;nota2;frequencia");
            bufferedWriter.newLine();

            for (Aluno aluno : alunos) {
                String linha = String.format(Locale.US, "%s;%s;%.2f;%.2f;%d",
                        aluno.getRa(),
                        aluno.getNome(),
                        aluno.getNota1(),
                        aluno.getNota2(),
                        aluno.getFrequencia());
                bufferedWriter.write(linha);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever o arquivo");
        }
    }

    public void exportarRelatorio(List<Aluno> alunos, String caminho) {
        try (
                FileOutputStream outputStream = new FileOutputStream(caminho, false);
                OutputStreamWriter streamWriter =
                        new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
                BufferedWriter bufferedWriter = new BufferedWriter(streamWriter)
        ) {
            bufferedWriter.write("ra;nome;media;situacao");
            bufferedWriter.newLine();

            for (Aluno aluno : alunos) {
                String linha = String.format(Locale.US, "%s;%s;%.2f;%s",
                        aluno.getRa(),
                        aluno.getNome(),
                        aluno.calcularMedia(),
                        aluno.calcularSituacao());
                bufferedWriter.write(linha);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever o arquivo");
        }
    }

    public void exportarPorSituacao(List<Aluno> alunos, String diretorio) {
        List<Aluno> aprovados = new ArrayList<>();
        List<Aluno> recuperacao = new ArrayList<>();
        List<Aluno> reprovados = new ArrayList<>();

        for (Aluno aluno : alunos) {
            String situacao = aluno.calcularSituacao();
            if (situacao.equals("APROVADO")) {
                aprovados.add(aluno);
            } else if (situacao.equals("RECUPERACAO")) {
                recuperacao.add(aluno);
            } else {
                reprovados.add(aluno);
            }
        }

        String base = diretorio.endsWith("/") || diretorio.endsWith("\\")
                ? diretorio
                : diretorio + "/";

        exportarRelatorio(aprovados, base + "aprovados.csv");
        exportarRelatorio(recuperacao, base + "recuperacao.csv");
        exportarRelatorio(reprovados, base + "reprovados.csv");
    }

    public void processarRecuperacao(InputStream alunos, InputStream notas, String caminhoSaida) {
        List<Aluno> importados = importarAlunos(alunos);
        List<Aluno> semRepetidos = new ArrayList<>();
        Set<String> rasVistos = new HashSet<>();
        for (Aluno aluno : importados) {
            if (aluno.getRa() != null && !aluno.getRa().isEmpty()
                    && rasVistos.add(aluno.getRa())) {
                semRepetidos.add(aluno);
            }
        }

        Map<String, Double> notasRecuperacao = importarNotasRecuperacao(notas);

        try (
                FileOutputStream outputStream = new FileOutputStream(caminhoSaida, false);
                OutputStreamWriter streamWriter =
                        new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
                BufferedWriter bufferedWriter = new BufferedWriter(streamWriter)
        ) {
            bufferedWriter.write("ra;nome;media;notaRecuperacao;mediaFinal;situacao");
            bufferedWriter.newLine();

            for (Aluno aluno : semRepetidos) {
                if (!aluno.calcularSituacao().equals("RECUPERACAO")) {
                    continue;
                }

                Double media = aluno.calcularMedia();
                Double notaRecuperacao = notasRecuperacao.getOrDefault(aluno.getRa(), 0.0);
                Double mediaFinal = (media + notaRecuperacao) / 2;
                String situacao = mediaFinal >= 6 ? "APROVADO" : "REPROVADO";

                String linha = String.format(Locale.US, "%s;%s;%.2f;%.2f;%.2f;%s",
                        aluno.getRa(),
                        aluno.getNome(),
                        media,
                        notaRecuperacao,
                        mediaFinal,
                        situacao);
                bufferedWriter.write(linha);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever o arquivo");
        }
    }

    private Map<String, Double> importarNotasRecuperacao(InputStream entrada) {
        Map<String, Double> notas = new HashMap<>();
        if (entrada == null) {
            return notas;
        }

        try {
            InputStreamReader inputStreamReader =
                    new InputStreamReader(entrada, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.isBlank()) {
                    continue;
                }

                String[] colunas = linha.split(";", -1);
                if (colunas.length != 2) {
                    continue;
                }

                try {
                    String ra = colunas[0].trim();
                    Double nota = Double.valueOf(colunas[1].trim());
                    notas.putIfAbsent(ra, nota);
                } catch (NumberFormatException e) {
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo");
        }
        return notas;
    }
}