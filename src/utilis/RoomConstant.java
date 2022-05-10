package utilis;

public class RoomConstant {
	
	public static final int SPAWNING_RATIO = 30;
	public static final int FORBIDDEN_ZOMBIE_SPAWN = 3;
	
	public static final int MAX_X = Constant.GAME_WIDTH / Constant.horizontalAspectRatio(Constant.GAME_WIDTH / 15);
	public static final int MAX_Y = Constant.TOP_HEIGHT / Constant.verticalAspectRatio(Constant.TOP_HEIGHT / 10);

	public static final int MIN_X = Constant.GAME_WIDTH / Constant.horizontalAspectRatio(Constant.GAME_WIDTH / 6);
	public static final int MIN_Y = Constant.TOP_HEIGHT / Constant.verticalAspectRatio(Constant.TOP_HEIGHT / 5);
	
}
