package tcp;

public class Command {
	public enum AllCmds {
	CREATE,
	JOIN,
	NICK,
	MSG,
	LIST,
	SHOW,
	WHERE;
	}
	public String value;
	public AllCmds cmd;
	Command(String s,AllCmds cmd) {
		this.value=s;
		this.cmd=cmd;
	}
}
