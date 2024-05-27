package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import classes.CSVUtil;
import classes.Passageiro;
import classes.Viagem;
import decorations.Color;

public class Main {

	private static List<Passageiro> passageiros = new ArrayList<Passageiro>();
	private static List<Viagem> viagens = new ArrayList<Viagem>();
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int primeiraOpcao;
		int segundaOpcao;
		
		do {
			
			System.out.println(Color.yellow() + "\n-=-=-=Menu Principal-=-=-=" + Color.reset());
			System.out.println(Color.yellow() + "||"  + Color.reset() + " 1. CSV               " + Color.yellow() + "||"  + Color.reset());
			System.out.println(Color.yellow() + "||"  + Color.reset() + " 2. Passageiros       " + Color.yellow() + "||"  + Color.reset());
			System.out.println(Color.yellow() + "||"  + Color.reset() + " 3. Viagens           " + Color.yellow() + "||"  + Color.reset());
			System.out.println(Color.yellow() + "||"  + Color.reset() + " 4. Encerrar programa " + Color.yellow() + "||"  + Color.reset());
			System.out.println(Color.yellow() + "-=-=-=-=-=-=-=-=-=-=-=-=-=" + Color.reset());
			System.out.println("Escolha uma opção: ");
			
			primeiraOpcao = scanner.nextInt();
			scanner.nextLine();
			
			switch (primeiraOpcao) {
			
			case 1:
				
				do {
					
					System.out.println(Color.yellow() + "\n-=-=-=-=-=CSV-=-=-=-=-" + Color.reset());
					System.out.println(Color.yellow() + "*"  + Color.reset() + " 1. Ler arquivo CSV " + Color.yellow() + "*"  + Color.reset());
					System.out.println(Color.yellow() + "*"  + Color.reset() + " 2. Voltar          " + Color.yellow() + "*"  + Color.reset());
					System.out.println(Color.yellow() + "-=-=-=-=-=-=-=-=-=-=-=" + Color.reset());
					System.out.println("Escolha uma opção: ");
					
					segundaOpcao = scanner.nextInt();
					scanner.nextLine();
					
					switch(segundaOpcao) {
					
					case 1:
						lerArquivoCSV();
						break;
						
					case 2:
						System.out.println(Color.green() + "\nVoltando ao menu principal..." + Color.reset());
						break;
						
					default:
						System.out.println(Color.red() + "Opção inválida, tente novamente!" + Color.reset());
					
					}
					
				} while(segundaOpcao != 2);
				
				break;
				
			case 2:
				
                do {
					
					System.out.println(Color.yellow() + "\n-=-=-=-=-=Passageiros-=-=-=-=-" + Color.reset());
					System.out.println(Color.yellow() + "*"  + Color.reset() + " 1. Inserir novo passageiro " + Color.yellow() + "*"  + Color.reset());
					System.out.println(Color.yellow() + "*"  + Color.reset() + " 2. Mostrar passageiros     " + Color.yellow() + "*"  + Color.reset());
					System.out.println(Color.yellow() + "*"  + Color.reset() + " 3. Baixar passageiros      " + Color.yellow() + "*"  + Color.reset());
					System.out.println(Color.yellow() + "*"  + Color.reset() + " 4. Voltar                  " + Color.yellow() + "*"  + Color.reset());
					System.out.println(Color.yellow() + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" + Color.reset());
					System.out.println("Escolha uma opção: ");
					
					segundaOpcao = scanner.nextInt();
					scanner.nextLine();
					
					switch(segundaOpcao) {
					
					case 1:
						registrarPassageiro(scanner);
						break;
						
					case 2:
						mostrarPassageiros();
						break;
						
					case 3:
						CSVUtil.exportarPassageirosParaCSV(passageiros);
						break;
						
					case 4:
						System.out.println(Color.green() + "\nVoltando ao menu principal..." + Color.reset());
						break;
						
					default:
						System.out.println(Color.red() + "Opção inválida, tente novamente!" + Color.reset());
					
					}
					
				} while(segundaOpcao != 4);
				
				break;
			
			case 3:
				
                do {
					
					System.out.println(Color.yellow() + "\n-=-=-=-=-=Viagens=-=-=-=-=" + Color.reset());
					System.out.println(Color.yellow() + "*"  + Color.reset() + " 1. Inserir nova viagem " + Color.yellow() + "*"  + Color.reset());
					System.out.println(Color.yellow() + "*"  + Color.reset() + " 2. Mostrar viagens     " + Color.yellow() + "*"  + Color.reset());
					System.out.println(Color.yellow() + "*"  + Color.reset() + " 3. Baixar viagens      " + Color.yellow() + "*"  + Color.reset());
					System.out.println(Color.yellow() + "*"  + Color.reset() + " 4. Voltar              " + Color.yellow() + "*"  + Color.reset());
					System.out.println(Color.yellow() + "-=-=-=-=-=-=-=-=-=-=-=-=-=" + Color.reset());
					System.out.println("Escolha uma opção: ");
					
					segundaOpcao = scanner.nextInt();
					scanner.nextLine();
					
					switch(segundaOpcao) {
					
					case 1:
						registrarViagem(scanner);
						break;
						
					case 2:
						mostrarViagens();
						break;
						
					case 3:
						CSVUtil.exportarViagensParaCSV(viagens);
						break;
						
					case 4:
						System.out.println(Color.green() + "\nVoltando ao menu principal..." + Color.reset());
						break;
						
					default:
						System.out.println(Color.red() + "Opção inválida, tente novamente!" + Color.reset());
					
					}
					
				} while(segundaOpcao != 4);
				
				break;
			
			case 4:
				System.out.println(Color.green() + "\nEncerrando o programa..." + Color.reset());
				break;
			
			default:
				System.out.println(Color.red() + "Opção inválida, tente novamente!" + Color.reset());
			
			}
			
		} while(primeiraOpcao != 4);
		
		scanner.close();
	}
	
	private static void lerArquivoCSV() {
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Selecione o arquivo CSV");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivo CSV", "csv"));
		
		int resultado = fileChooser.showOpenDialog(null);
		if (resultado == JFileChooser.APPROVE_OPTION) {
			
			String caminhoDoArquivo = fileChooser.getSelectedFile().getAbsolutePath();
			try (BufferedReader bufferedReader = new BufferedReader(new FileReader(caminhoDoArquivo))) {
				
				String cabecalho = bufferedReader.readLine();
				if (cabecalho != null) {
					
					if (cabecalho.contains("nome") && 
						cabecalho.contains("sobrenome") && 
						cabecalho.contains("rg") &&
						cabecalho.contains("passaporte")) lerPassageiros(bufferedReader);
					
					else if (cabecalho.contains("voo") &&
							cabecalho.contains("dataDePartida") &&
							cabecalho.contains("dataDeRetorno") &&
							cabecalho.contains("destino") &&
							cabecalho.contains("passageiros")) lerViagens(bufferedReader);
					
					else JOptionPane.showMessageDialog(null, 
							"Formato de arquivo CSV desconhecido",
							"Erro", JOptionPane.ERROR_MESSAGE);
					
				}
				
			} catch (IOException error) {
				
				JOptionPane.showMessageDialog(null, 
						"Erro ao ler o arquivo CSV: " + error.getMessage(), 
						"Erro", JOptionPane.ERROR_MESSAGE );
				
			}
			
		}
		
	}
	
	private static void lerPassageiros(BufferedReader bufferedReader) throws IOException {
	    String linha;
	    while ((linha = bufferedReader.readLine()) != null) {
	        String[] dados = linha.split(",");
	        if (dados.length == 4) {
	            Passageiro passageiro = new Passageiro(dados[0], dados[1], dados[2], dados[3]);
	            passageiros.add(passageiro);
	        } else {
	            System.out.println(Color.red() + "Formato inválido de linha para passageiro: " + linha + Color.reset());
	        }
	    }
	    System.out.println(Color.green() + "\nPassageiros importados com sucesso!\n" + Color.reset());
	}



	private static void lerViagens(BufferedReader bufferedReader) throws IOException {
	    String linha;
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	    while ((linha = bufferedReader.readLine()) != null) {
	        String[] dados = linha.split(",");
	        if (dados.length == 5) {
	            try {
	                Date dataDePartida = simpleDateFormat.parse(dados[1]);
	                Date dataDeRetorno = simpleDateFormat.parse(dados[2]);

	                List<Passageiro> passageirosViagem = new ArrayList<>();
	                String[] rgs = dados[4].split(";");

	                for (String rg : rgs) {
	                    Passageiro passageiro = buscarPassageiroPorRg(rg.trim());
	                    if (passageiro != null && !contemRg(passageirosViagem, rg.trim())) {
	                        passageirosViagem.add(passageiro);
	                    } else {
	                        System.out.println(Color.red() + "Passageiro com RG " + rg.trim() + " não encontrado." + Color.reset());
	                    }
	                }

	                Viagem viagem = new Viagem(dados[0], dataDePartida, dataDeRetorno, dados[3], passageirosViagem);
	                viagens.add(viagem);

	            } catch (Exception error) {
	                System.out.println(Color.red() + "Erro ao parsear viagem: " + linha + "\nErro: " + error.getMessage() + Color.reset());
	            }
	        } else {
	            System.out.println(Color.red() + "Formato inválido de linha para viagem: " + linha + Color.reset());
	        }
	    }

	    System.out.println(Color.green() + "\nViagens importadas com sucesso!" + Color.reset());
	}


	

	private static void registrarPassageiro(Scanner scanner) {
		
		System.out.println("Digite o nome do passageiro: ");
		String nome = scanner.nextLine();
		
		System.out.println("Digite o sobrenome do passageiro: ");
		String sobrenome = scanner.nextLine();
		
		System.out.println("Digite o RG do passageiro: ");
		String rg = scanner.nextLine();
		
		System.out.println("Digite o passaporte do passageiro: ");
		String passaporte = scanner.nextLine();
		
		Passageiro passageiro = new Passageiro(nome, sobrenome, rg, passaporte);
		passageiros.add(passageiro);
		
		System.out.println(Color.green() + "\nPassageiro inserido com sucesso!\n" + Color.reset());
		
	}
	
	private static void registrarViagem(Scanner scanner) {
	    System.out.println("Digite o código do voo: ");
	    String voo = scanner.nextLine();

	    System.out.println("Digite a data de partida (dd/MM/yyyy): ");
	    String strDataDePartida = scanner.nextLine();

	    System.out.println("Digite a data de retorno (dd/MM/yyyy): ");
	    String strDataDeRetorno = scanner.nextLine();

	    System.out.println("Digite o destino: ");
	    String destino = scanner.nextLine();

	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    Date dataDePartida = null;
	    Date dataDeRetorno = null;

	    try {
	        dataDePartida = simpleDateFormat.parse(strDataDePartida);
	        dataDeRetorno = simpleDateFormat.parse(strDataDeRetorno);
	    } catch (Exception error) {
	        System.out.println(Color.red() + "Formato de data inválido, use dd/MM/yyyy" + Color.reset());
	        return;
	    }

	    List<Passageiro> passageirosViagem = new ArrayList<>();
	    System.out.println("Digite os RGs dos passageiros que participarão da viagem (separados por ponto e vírgula): ");
	    String rgsStr = scanner.nextLine();
	    String[] rgs = rgsStr.split(";");

	    for (String rg : rgs) {
	        boolean passageiroEncontrado = false;
	        while (!passageiroEncontrado) {
	            Passageiro passageiro = buscarPassageiroPorRg(rg.trim());
	            if (passageiro != null && !contemRg(passageirosViagem, rg.trim())) {
	                passageirosViagem.add(passageiro);
	                passageiroEncontrado = true;
	            } else {
	                System.out.println(Color.red() + "Passageiro com RG " + rg.trim() + " não encontrado. Por favor, digite um RG válido." + Color.reset());
	                rg = scanner.nextLine();
	            }
	        }
	    }

	    Viagem viagem = new Viagem(voo, dataDePartida, dataDeRetorno, destino, passageirosViagem);
	    viagens.add(viagem);

	    System.out.println(Color.green() + "\nViagem registrada com sucesso!\n" + Color.reset());
	}

	
	private static Passageiro buscarPassageiroPorRg(String rg) {
        for (Passageiro passageiro : passageiros) {
            if (passageiro.getRg().equals(rg)) {
                return passageiro;
            }
        }
        return null;
    }
	
	private static boolean contemRg(List<Passageiro> passageiros, String rg) {
        for (Passageiro passageiro : passageiros) {
            if (passageiro.getRg().equals(rg)) {
                return true;
            }
        }
        return false;
    }
	
	private static void mostrarPassageiros() {
	    if (passageiros.isEmpty()) {
	        System.out.println(Color.yellow() + "\nNão há passageiros cadastrados." + Color.reset());
	    } else {
	        System.out.println(Color.yellow() + "\n-=-=-=-=-=Lista de Passageiros-=-=-=-=-" + Color.reset());
	        for (Passageiro passageiro : passageiros) {
	            System.out.println(passageiro.toString() + "\n");
	        }
	        System.out.println(Color.yellow() + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-" + Color.reset());
	    }
	}
	
	private static void mostrarViagens() {
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	    if (viagens.isEmpty()) {
	        System.out.println(Color.yellow() + "\nNão há viagens cadastradas." + Color.reset());
	    } else {
	        System.out.println(Color.yellow() + "\n-=-=-=-=-=Lista de Viagens-=-=-=-=-" + Color.reset());
	        for (Viagem viagem : viagens) {
	            String dataDePartida = simpleDateFormat.format(viagem.getDataDePartida());
	            String dataDeRetorno = simpleDateFormat.format(viagem.getDataDeRetorno());
	            
	            System.out.println("\nVoo: " + viagem.getVoo()
	                    + "\nData de Partida: " + dataDePartida
	                    + "\nData de Retorno: " + dataDeRetorno
	                    + "\nDestino: " + viagem.getDestino()
	                    + "\nPassageiros: " + viagem.getPassageiros().toString());
	        }
	        System.out.println(Color.yellow() + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-" + Color.reset());
	    }
	}


}
