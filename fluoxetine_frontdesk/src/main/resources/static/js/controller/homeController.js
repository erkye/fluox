app.controller('homeController',function ($scope) {

    $scope.souplist = [];

    $scope.num = 0;

    $scope.initPage = function () {
        //15条数据
        $scope.souplist.push('没有太晚的开始，不如就从今天行动。总有一天，那个一点一点可见的未来，会在你心里，也在你的脚下慢慢清透。生活，从不亏待每一个努力向上的人。');
        $scope.souplist.push('你之所以会觉得难受，大概是因为你投入了大把时间和精力，到最后却没能得到你想要的东西，那种一瞬间被失落灌满的样子让你感到不值得。');
        $scope.souplist.push('最困难的时刻也许就是拐点的开始，改变一下思维方式就可能迎来转机。以平常心看世界，花开花谢都是风景。');
        $scope.souplist.push('既然选择了追求，就不要哭泣。坚持一下，扛过今天，幸福就更近一步。真正能把人累垮的，是心里的绝望。');
        $scope.souplist.push('每天给自己一个希望，试着不为明天而烦恼，不为昨天而叹息，只为今天更美好。');
        $scope.souplist.push('别小看任何人，越不起眼的人、往往会做些让人想不到的事。');
        $scope.souplist.push('不要去听别人的忽悠，你人生的每一步都必须靠自己的能力完成。自己肚子里没有料，手上没本事，认识再多人也没用。');
        $scope.souplist.push('不为失败找理由，要为成功找方法。决定今天的不是今天，而是昨天对人生的态度；决定明天的不是明天，而是今天对事业的作为。我们的今天由过去决定，我们的明天由今天决定！');
        $scope.souplist.push('只要认真计划一件事，并且一边坚持一边调整，往往会完成得十分出色。懈怠的情绪谁都会有，不要担心自己比别人走得慢，也不要因暂时的挫折心灰意冷，只要不断调整心态，不停下脚步，最终能抵达终点。');
        $scope.souplist.push('人生是一次旅程，有上坡也有下坡。我不在乎自己的终点是坡顶还是谷底，只在乎沿路的风景美丽而富有生机！');
        $scope.souplist.push('生活不是一场赛跑，生活是一场旅行，要懂得好好欣赏每一段的风景。不要只因一次失败，就放弃你原来决心想达到的目的。');
        $scope.souplist.push('当你觉得累，不是因为路上坎坷太多，而是因为忘记了要去哪里。人生路上，难免被琐碎人情所牵制，也常常因此忘记了方向。人生最幸福的事：有方向，在路上。');
        $scope.souplist.push('人生没有彩排，每天都是精彩的比赛，所以，再苦，也要学会坚持，再累，也要爱自己；再烦，也别忘记微笑；再急，也要注意语气；再痛，也要学会忘记！');
        $scope.souplist.push('宁可自信，也不要盲目悲观。因为自信是一种力量，即使你的自信有些盲目，也无关大局，你可以在实践中调整心态，找到自己的恰当的位置。如果盲目自卑，你就必然失去一切。');
        $scope.souplist.push('不管你从什么时候开端，重要的是开端后就不要停止；不管你从什么时候完毕，重要的是完毕后就不要懊悔');

        $scope.num = Math.floor(Math.random() * 15);

    }

});