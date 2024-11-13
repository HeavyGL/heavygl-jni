JAVA_SRC_DIR = src/main/java/org/josl/heavygl
C_SRC_DIR = src/main/c
GENERATED_C_CODE = src/generated/c

PROJ_ROOT = ../..
TOOLS_DIR = $(PROJ_ROOT)/bin/tools
BUILD_DLL_DIR = $(PROJ_ROOT)/bin/dll

# Modify these if necessary
gcc64 = $(TOOLS_DIR)/mingw64/bin/gcc
gcc32 = gcc

# Generate headers
headers: $(JAVA_SRC_DIR)/HGL11C.java
	@echo : Generating headers for HGL11C.java...
	@javac -h $(GENERATED_C_CODE) $(JAVA_SRC_DIR)/HGL11C.java
	@echo : Done!

clean:
	@rm -rf $(BUILD_DLL_DIR)/*

# DLL's stuff

dlls: $(C_SRC_DIR)/org_josl_heavygl_HGL11C.c
	@echo : Generating 64-bits DLL file...
	@"$(gcc64)" -shared -o $(BUILD_DLL_DIR)/heavygl.dll -I"${JAVA_HOME}/include" -I"${JAVA_HOME}/include/win32" $(C_SRC_DIR)/*.c
	@echo : Done!

copy-dlls: $(BUILD_DLL_DIR)/heavygl.dll
	@rm -f natives/windows/heavygl.dll
	@cp $(BUILD_DLL_DIR)/heavygl.dll natives/windows/heavygl.dll
	@echo : Dlls copied successfully!

gz-dlls:
	@cp $(BUILD_DLL_DIR)/heavygl.dll $(BUILD_DLL_DIR)/heavygl_.dll
	@gzip -fv9 $(BUILD_DLL_DIR)/heavygl.dll
	@mv $(BUILD_DLL_DIR)/heavygl_.dll $(BUILD_DLL_DIR)/heavygl.dll

xz-dlls:
	@cp $(BUILD_DLL_DIR)/heavygl.dll $(BUILD_DLL_DIR)/heavygl_.dll
	@xz -fv9 $(BUILD_DLL_DIR)/heavygl.dll
	@mv $(BUILD_DLL_DIR)/heavygl_.dll $(BUILD_DLL_DIR)/heavygl.dll

compress-dlls: gz-dlls xz-dlls