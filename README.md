# TransitionDemo
### 学习Demo

* 此项目相当于笔记，参考自https://github.com/WakeHao/TransitionExample
>   下面是SceneTransition的源码，最低兼容Android API21
      /**
         * Create an ActivityOptions to transition between Activities using cross-Activity scene
         * animations. This method carries the position of multiple shared elements to the started
         * Activity. The position of the first element in sharedElements
         * will be used as the epicenter for the exit Transition. The position of the associated
         * shared element in the launched Activity will be the epicenter of its entering Transition.
         *
         * <p>This requires {@link android.view.Window#FEATURE_CONTENT_TRANSITIONS} to be
         * enabled on the calling Activity to cause an exit transition. The same must be in
         * the called Activity to get an entering transition.</p>
         * @param activity The Activity whose window contains the shared elements.
         * @param sharedElements The names of the shared elements to transfer to the called
         *                       Activity and their associated Views. The Views must each have
         *                       a unique shared element name.
         * @return Returns a new ActivityOptions object that you can use to
         *         supply these options as the options Bundle when starting an activity.
         */
        public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity,
                Pair<View, String>... sharedElements) {
            if (Build.VERSION.SDK_INT >= 21) {
                View[] views = null;
                String[] names = null;
                if (sharedElements != null) {
                    views = new View[sharedElements.length];
                    names = new String[sharedElements.length];
                    for (int i = 0; i < sharedElements.length; i++) {
                        views[i] = sharedElements[i].first;
                        names[i] = sharedElements[i].second;
                    }
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    return new ActivityOptionsCompat.ActivityOptionsImpl24(
                            ActivityOptionsCompat24.makeSceneTransitionAnimation(activity, views, names));
                } else if (Build.VERSION.SDK_INT >= 23) {
                    return new ActivityOptionsCompat.ActivityOptionsImpl23(
                            ActivityOptionsCompat23.makeSceneTransitionAnimation(activity, views, names));
                } else {
                    return new ActivityOptionsCompat.ActivityOptionsImpl21(
                            ActivityOptionsCompat21.makeSceneTransitionAnimation(activity, views, names));
                }
            }
            return new ActivityOptionsCompat();
        }
