package gdcp.service;

/**
 * @author WeiLiang
 * @date 2021/6/20 - 19:40
 */
public class TeamException extends Exception {
    static final long serialVersionUID = -3387516993124229948L;

    public TeamException() {
    }

    public TeamException(String message) {
        super(message);
    }
}
