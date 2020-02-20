//顶点着色器

attribute vec4 vPosition;//变量float[4]  一个顶点 x,y,z,w 4维坐标 Java传过来的

attribute vec2 vCoord; // 纹理坐标

varying vec2 aCoord;

uniform mat4 vMatrix;//矩阵

void main(){
    //内置变量：把左边点赋值给gl_position 就OK了。
    gl_Position = vPosition;

//    aCoord = (vMatrix * vec4(vCoord, 1.0, 1.0 )).xy;
    aCoord = vCoord;

}
