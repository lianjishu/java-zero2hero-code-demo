import subprocess
import matplotlib.pyplot as plt
import matplotlib
import time
import os

matplotlib.rcParams['font.sans-serif'] = ['SimHei', 'Microsoft YaHei', 'STHeiti']
matplotlib.rcParams['axes.unicode_minus'] = False

# Java 项目路径
project_dir = os.path.dirname(os.path.abspath(__file__))
classes_dir = os.path.join(project_dir, "target", "classes")

# 启动 Java 进程，捕获 stdout
proc = subprocess.Popen(
    ["java", "-cp", classes_dir, "implement1.TestFooThread"],
    stdout=subprocess.PIPE,
    stderr=subprocess.PIPE,
    text=True,
    encoding="gbk",
)

# 初始化绘图
plt.ion()
fig, ax = plt.subplots(figsize=(12, 5))

steps = []
thread_ids = []
colors_map = {1: '#E53935', 2: '#1E88E5'}

ax.set_xlabel('执行顺序 (第 N 次输出)', fontsize=13)
ax.set_ylabel('线程编号', fontsize=13)
ax.set_title('多线程交替执行实时可视化', fontsize=15, fontweight='bold')
ax.set_yticks([1, 2])
ax.set_yticklabels(['线程1', '线程2'], fontsize=12)
ax.set_ylim(0.5, 2.5)
ax.grid(True, axis='y', linestyle='--', alpha=0.5)

(line1,) = ax.plot([], [], color=colors_map[1], linewidth=2, marker='o',
                   markerfacecolor='white', markeredgecolor=colors_map[1],
                   markeredgewidth=2, markersize=8, label='线程1')
(line2,) = ax.plot([], [], color=colors_map[2], linewidth=2, marker='s',
                   markerfacecolor='white', markeredgecolor=colors_map[2],
                   markeredgewidth=2, markersize=8, label='线程2')
ax.legend(fontsize=12, loc='upper right')

count = 0
for line in proc.stdout:
    line = line.strip()
    if not line:
        continue

    count += 1
    if '线程1' in line:
        tid = 1
    else:
        tid = 2

    steps.append(count)
    thread_ids.append(tid)

    # 按线程分组更新
    s1 = [s for s, t in zip(steps, thread_ids) if t == 1]
    y1 = [t for t in thread_ids if t == 1]
    s2 = [s for s, t in zip(steps, thread_ids) if t == 2]
    y2 = [t for t in thread_ids if t == 2]

    line1.set_data(s1, y1)
    line2.set_data(s2, y2)

    ax.set_xlim(0, max(steps) + 1)
    ax.set_title(f'多线程交替执行实时可视化  —  第 {count} 次输出', fontsize=15, fontweight='bold')

    fig.canvas.draw()
    fig.canvas.flush_events()
    time.sleep(0.3)

proc.wait()

# 最终统计
c1 = thread_ids.count(1)
c2 = thread_ids.count(2)
ax.set_title(f'多线程交替执行可视化  —  线程1: {c1}次, 线程2: {c2}次, 共 {count} 次', fontsize=15, fontweight='bold')
fig.canvas.draw()

plt.ioff()
save_path = os.path.join(project_dir, 'thread_visualization.png')
plt.savefig(save_path, dpi=150, bbox_inches='tight')
print(f"图表已保存: {save_path}")
plt.show()
