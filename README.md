### 一致性哈希实现的缓存(OkCache)

测试输入：1000w个数据，100个服务器，每台服务器100个虚拟节点
>注意：测试数据较大，需设置jvm参数（`VM options: -Xms2g -Xmx2g `）

#### 测试结果
1. ##### 采用CRC32的hash算法
```text
开始存储10000000个kv数据
测试输出一个数据：
Name93939:0.07804853963130809
打印缓存统计信息如下:
服务器(192.168.0.0): 存储58508个数据
服务器(192.168.0.1): 存储71338个数据
服务器(192.168.0.2): 存储86112个数据
服务器(192.168.0.3): 存储88999个数据
服务器(192.168.0.4): 存储87347个数据
服务器(192.168.0.5): 存储89298个数据
服务器(192.168.0.6): 存储81677个数据
服务器(192.168.0.7): 存储83618个数据
服务器(192.168.0.8): 存储143208个数据
服务器(192.168.0.9): 存储142932个数据
服务器(192.168.0.10): 存储105256个数据
服务器(192.168.0.11): 存储106428个数据
服务器(192.168.0.12): 存储88704个数据
服务器(192.168.0.13): 存储94855个数据
服务器(192.168.0.14): 存储104850个数据
服务器(192.168.0.15): 存储114974个数据
服务器(192.168.0.16): 存储69484个数据
服务器(192.168.0.17): 存储70244个数据
服务器(192.168.0.18): 存储67527个数据
服务器(192.168.0.19): 存储65185个数据
服务器(192.168.0.20): 存储120513个数据
服务器(192.168.0.21): 存储131685个数据
服务器(192.168.0.22): 存储136304个数据
服务器(192.168.0.23): 存储112344个数据
服务器(192.168.0.24): 存储120489个数据
服务器(192.168.0.25): 存储139270个数据
服务器(192.168.0.26): 存储77515个数据
服务器(192.168.0.27): 存储80680个数据
服务器(192.168.0.28): 存储90470个数据
服务器(192.168.0.29): 存储93083个数据
服务器(192.168.0.30): 存储121161个数据
服务器(192.168.0.31): 存储135205个数据
服务器(192.168.0.32): 存储113431个数据
服务器(192.168.0.33): 存储124914个数据
服务器(192.168.0.34): 存储118508个数据
服务器(192.168.0.35): 存储112957个数据
服务器(192.168.0.36): 存储81156个数据
服务器(192.168.0.37): 存储83035个数据
服务器(192.168.0.38): 存储92587个数据
服务器(192.168.0.39): 存储90590个数据
服务器(192.168.0.40): 存储163129个数据
服务器(192.168.0.41): 存储127984个数据
服务器(192.168.0.42): 存储112944个数据
服务器(192.168.0.43): 存储113402个数据
服务器(192.168.0.44): 存储117921个数据
服务器(192.168.0.45): 存储110575个数据
服务器(192.168.0.46): 存储88528个数据
服务器(192.168.0.47): 存储81466个数据
服务器(192.168.0.48): 存储100557个数据
服务器(192.168.0.49): 存储86653个数据
服务器(192.168.0.50): 存储119851个数据
服务器(192.168.0.51): 存储136335个数据
服务器(192.168.0.52): 存储118407个数据
服务器(192.168.0.53): 存储111376个数据
服务器(192.168.0.54): 存储138585个数据
服务器(192.168.0.55): 存储124602个数据
服务器(192.168.0.56): 存储93107个数据
服务器(192.168.0.57): 存储95344个数据
服务器(192.168.0.58): 存储102559个数据
服务器(192.168.0.59): 存储92233个数据
服务器(192.168.0.60): 存储111092个数据
服务器(192.168.0.61): 存储145669个数据
服务器(192.168.0.62): 存储113838个数据
服务器(192.168.0.63): 存储107639个数据
服务器(192.168.0.64): 存储116436个数据
服务器(192.168.0.65): 存储139950个数据
服务器(192.168.0.66): 存储74226个数据
服务器(192.168.0.67): 存储82688个数据
服务器(192.168.0.68): 存储68286个数据
服务器(192.168.0.69): 存储77708个数据
服务器(192.168.0.70): 存储96408个数据
服务器(192.168.0.71): 存储97922个数据
服务器(192.168.0.72): 存储98607个数据
服务器(192.168.0.73): 存储108131个数据
服务器(192.168.0.74): 存储108103个数据
服务器(192.168.0.75): 存储120991个数据
服务器(192.168.0.76): 存储77742个数据
服务器(192.168.0.77): 存储84524个数据
服务器(192.168.0.78): 存储86769个数据
服务器(192.168.0.79): 存储83493个数据
服务器(192.168.0.80): 存储85065个数据
服务器(192.168.0.81): 存储85690个数据
服务器(192.168.0.82): 存储81759个数据
服务器(192.168.0.83): 存储82961个数据
服务器(192.168.0.84): 存储98746个数据
服务器(192.168.0.85): 存储94476个数据
服务器(192.168.0.86): 存储71373个数据
服务器(192.168.0.87): 存储62237个数据
服务器(192.168.0.88): 存储90947个数据
服务器(192.168.0.89): 存储83658个数据
服务器(192.168.0.90): 存储77348个数据
服务器(192.168.0.91): 存储85335个数据
服务器(192.168.0.92): 存储98437个数据
服务器(192.168.0.93): 存储93361个数据
服务器(192.168.0.94): 存储113239个数据
服务器(192.168.0.95): 存储106345个数据
服务器(192.168.0.96): 存储79060个数据
服务器(192.168.0.97): 存储84174个数据
服务器(192.168.0.98): 存储99971个数据
服务器(192.168.0.99): 存储93597个数据
总共100台服务器, kv总数据量：10000000个
平均值：100000.00
最大值：163129,（163.13%）
最小值：58508,（58.51%）
极差：104621,（104.62%）
标准差：17881.78,（17.88%）
```

2. ##### 采用Google Guava的哈希算法
```text
开始存储10000000个kv数据
测试输出一个数据：
Name93939:0.6989422059059499
打印缓存统计信息如下:
服务器(192.168.0.0): 存储116470个数据
服务器(192.168.0.1): 存储103592个数据
服务器(192.168.0.2): 存储95491个数据
服务器(192.168.0.3): 存储96333个数据
服务器(192.168.0.4): 存储93962个数据
服务器(192.168.0.5): 存储112182个数据
服务器(192.168.0.6): 存储90944个数据
服务器(192.168.0.7): 存储87113个数据
服务器(192.168.0.8): 存储87415个数据
服务器(192.168.0.9): 存储84502个数据
服务器(192.168.0.10): 存储91667个数据
服务器(192.168.0.11): 存储98062个数据
服务器(192.168.0.12): 存储105806个数据
服务器(192.168.0.13): 存储115124个数据
服务器(192.168.0.14): 存储105110个数据
服务器(192.168.0.15): 存储92679个数据
服务器(192.168.0.16): 存储117474个数据
服务器(192.168.0.17): 存储87636个数据
服务器(192.168.0.18): 存储111190个数据
服务器(192.168.0.19): 存储91891个数据
服务器(192.168.0.20): 存储82767个数据
服务器(192.168.0.21): 存储106369个数据
服务器(192.168.0.22): 存储101937个数据
服务器(192.168.0.23): 存储89984个数据
服务器(192.168.0.24): 存储94201个数据
服务器(192.168.0.25): 存储101052个数据
服务器(192.168.0.26): 存储98040个数据
服务器(192.168.0.27): 存储101684个数据
服务器(192.168.0.28): 存储99669个数据
服务器(192.168.0.29): 存储101906个数据
服务器(192.168.0.30): 存储103696个数据
服务器(192.168.0.31): 存储98513个数据
服务器(192.168.0.32): 存储86075个数据
服务器(192.168.0.33): 存储94359个数据
服务器(192.168.0.34): 存储89870个数据
服务器(192.168.0.35): 存储103650个数据
服务器(192.168.0.36): 存储93286个数据
服务器(192.168.0.37): 存储106214个数据
服务器(192.168.0.38): 存储95040个数据
服务器(192.168.0.39): 存储119881个数据
服务器(192.168.0.40): 存储101277个数据
服务器(192.168.0.41): 存储94022个数据
服务器(192.168.0.42): 存储107172个数据
服务器(192.168.0.43): 存储99532个数据
服务器(192.168.0.44): 存储104824个数据
服务器(192.168.0.45): 存储91238个数据
服务器(192.168.0.46): 存储113744个数据
服务器(192.168.0.47): 存储101848个数据
服务器(192.168.0.48): 存储85815个数据
服务器(192.168.0.49): 存储115545个数据
服务器(192.168.0.50): 存储113258个数据
服务器(192.168.0.51): 存储102175个数据
服务器(192.168.0.52): 存储96491个数据
服务器(192.168.0.53): 存储97608个数据
服务器(192.168.0.54): 存储85743个数据
服务器(192.168.0.55): 存储89009个数据
服务器(192.168.0.56): 存储91094个数据
服务器(192.168.0.57): 存储102790个数据
服务器(192.168.0.58): 存储82196个数据
服务器(192.168.0.59): 存储97022个数据
服务器(192.168.0.60): 存储92235个数据
服务器(192.168.0.61): 存储95459个数据
服务器(192.168.0.62): 存储95445个数据
服务器(192.168.0.63): 存储103241个数据
服务器(192.168.0.64): 存储99877个数据
服务器(192.168.0.65): 存储106250个数据
服务器(192.168.0.66): 存储108243个数据
服务器(192.168.0.67): 存储102953个数据
服务器(192.168.0.68): 存储91430个数据
服务器(192.168.0.69): 存储98358个数据
服务器(192.168.0.70): 存储103372个数据
服务器(192.168.0.71): 存储107016个数据
服务器(192.168.0.72): 存储107083个数据
服务器(192.168.0.73): 存储96676个数据
服务器(192.168.0.74): 存储105516个数据
服务器(192.168.0.75): 存储94000个数据
服务器(192.168.0.76): 存储118789个数据
服务器(192.168.0.77): 存储90658个数据
服务器(192.168.0.78): 存储94132个数据
服务器(192.168.0.79): 存储93167个数据
服务器(192.168.0.80): 存储99233个数据
服务器(192.168.0.81): 存储133019个数据
服务器(192.168.0.82): 存储100070个数据
服务器(192.168.0.83): 存储100579个数据
服务器(192.168.0.84): 存储128278个数据
服务器(192.168.0.85): 存储95321个数据
服务器(192.168.0.86): 存储94185个数据
服务器(192.168.0.87): 存储89783个数据
服务器(192.168.0.88): 存储85659个数据
服务器(192.168.0.89): 存储105586个数据
服务器(192.168.0.90): 存储106682个数据
服务器(192.168.0.91): 存储93798个数据
服务器(192.168.0.92): 存储117697个数据
服务器(192.168.0.93): 存储105331个数据
服务器(192.168.0.94): 存储110892个数据
服务器(192.168.0.95): 存储92051个数据
服务器(192.168.0.96): 存储115310个数据
服务器(192.168.0.97): 存储94600个数据
服务器(192.168.0.98): 存储98344个数据
服务器(192.168.0.99): 存储104443个数据
总共100台服务器, kv总数据量：10000000个
平均值：100000.00
最大值：133019,（133.02%）
最小值：82196,（82.20%）
极差：50823,（50.82%）
标准差：7726.40,（7.73%）
```

### 结论：
1. 一致性哈希算法旨在解决数据分片时系统水平伸缩带来的数据失效问题，同时通过虚拟节点使每个节点均匀散列到环上，避免因数据倾斜导致系统负载不均衡问题。
2. 一致性哈希算法实现的优劣：重点在于节点的散列程度是否均匀。也就是说，虚拟节点数量相同的情况下，程序中HashAlgorithm的实现的好坏是整个的核心。
> 从实验数据上可以清楚的看到：设置不同的hash实现，最终的结果(标准差)差别很大。
