package utilis;

public class RoomConstant {
	
	public static final int SPAWNING_RATIO = 30;
	public static final int FORBIDDEN_ZOMBIE_SPAWN = 3;
	
	private final int maxX = Constant.GAME_WIDTH / Constant.horizontalAspectRatio(Constant.GAME_WIDTH / 15);
	private final int maxY = Constant.TOP_HEIGHT / Constant.verticalAspectRatio(Constant.TOP_HEIGHT / 10);

	private final int minX = Constant.GAME_WIDTH / Constant.horizontalAspectRatio(Constant.GAME_WIDTH / 6);
	private final int minY = Constant.TOP_HEIGHT / Constant.verticalAspectRatio(Constant.TOP_HEIGHT / 5);
	
}
