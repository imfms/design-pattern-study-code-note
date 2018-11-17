package cn.f_ms.study.design_pattern.p06builder;

/**
 * 视频播放软件(video_player)
 * 拥有多种界面展示
 * ○ 完整模式 菜单，播放列表，收藏列表，主窗口，控制条
 * ○ 精简模式 主窗口，控制条
 * ○ 记忆模式 主窗口，控制条，收藏列表
 *
 * @author imf_m
 * @date 2018/11/17
 */
class S4_VideoPlayer {

    class Display {
        boolean isExistMainWindow;
        boolean isExistControlBar;
        boolean isExistPlayList;
        boolean isExistCollectList;
    }

    abstract class UiBuilder {

        private Display display = new Display();

        void buildMainWindow() {
            display.isExistMainWindow = true;
        }
        void buildControlBar() {
            display.isExistControlBar = true;
        }
        abstract boolean isBuildPlayList();
        void buildPlayList() {
            display.isExistPlayList = true;
        }
        abstract boolean isBuildCollectList();
        void buildCollectList() {
            display.isExistCollectList = true;
        }


        Display contract() {

            buildMainWindow();
            buildControlBar();

            if (isBuildPlayList()) {
                buildPlayList();
            }
            if (isBuildCollectList()) {
                buildCollectList();
            }

            return display;
        }
    }
    class FullModeUiBuider extends UiBuilder {

        @Override
        boolean isBuildPlayList() {
            return true;
        }

        @Override
        boolean isBuildCollectList() {
            return true;
        }
    }
    class SimpleModeUiBuider extends UiBuilder {

        @Override
        boolean isBuildPlayList() {
            return false;
        }

        @Override
        boolean isBuildCollectList() {
            return false;
        }
    }
    class MemeryModeUiBuider extends UiBuilder {

        @Override
        boolean isBuildPlayList() {
            return false;
        }

        @Override
        boolean isBuildCollectList() {
            return true;
        }
    }
}
