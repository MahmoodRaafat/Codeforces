/*

A - Chat Server's Outgoing Traffic

Polycarp is working on a new project called "Polychat". Following modern tendencies in IT, 
he decided that this project should contain chat as well. To achieve this goal, Polycarp 
has spent several hours in front of his laptop and implemented a chat server that can 
process three types of commands: (1) Include a person to the chat ('Add' command). 
(2) Remove a person from the chat ('Remove' command). (3) Send a message from a person to 
all people who are currently in the chat, including the one who sends the message ('Send' 
command). Now Polycarp wants to find out the amount of outgoing traffic that the server 
will produce while processing a particular set of commands. Polycarp knows that chat 
server sends no traffic for 'Add' and 'Remove' commands. When 'Send' command is processed, 
server sends l bytes to each participant of the chat, where l is the length of the message.
As Polycarp has no time, he is asking for your help in solving this problem.

Input
Input file will contain not more than 100 commands, each in its own line. No line will 
exceed 100 characters. Formats of the commands will be the following:
    +<name> for 'Add' command.
    -<name> for 'Remove' command.
    <sender_name>:<message_text> for 'Send' command. 
<name> and <sender_name> is a non-empty sequence of Latin letters and digits. <message_text> 
can contain letters, digits and spaces, but can't start or end with a space. <message_text> 
can be an empty line. It is guaranteed, that input data are correct, i.e. there will be no 
'Add' command if person with such a name is already in the chat, there will be no 'Remove' 
command if there is no person with such a name in the chat etc. All names are case-sensitive.

Output
Print a single number — answer to the problem.

--------------------------------------------------------------------------------------------*/

import java.util.*;
import java.io.*;
public class A0005_ChatServersOutgoingTraffic {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> commands = readInput(in);
		
		int peopleInChat = 0, result = 0;
		for (int i=0; i<commands.size(); i++) {
			char first = commands.get(i).charAt(0);
			if (first == '+')
				peopleInChat++;
			else if (first == '-')
				peopleInChat--;
			else
				result += peopleInChat*getMessageLength(commands.get(i));
		}
		System.out.println(result);
	}

	public static int getMessageLength(String command) {
		for (int i=0; i<command.length(); i++)
			if (command.charAt(i)==':')
				return command.substring(i+1).length();
		return 0;
	}
	
	public static ArrayList<String> readInput(BufferedReader in) throws IOException {
		ArrayList<String> list = new ArrayList<String>();
		String line = in.readLine();
		while (line != null) {
			list.add(line);
			if (in.ready())
				line = in.readLine();
			else
				line = null;
		}
		return list;
	}
}
